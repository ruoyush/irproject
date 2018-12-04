package PseudoRFSearch;

import Classes.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Classes.Document;
import Classes.Query;
import IndexingLucene.MyIndexReader;
import SearchLucene.QueryRetrievalModel;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class PseudoRFRetrievalModel {

	MyIndexReader ixreader;
        private int u = 2000;
	private Map<String, Double> p_ref;
        long totalterm = (long) 3913068.0;
	public PseudoRFRetrievalModel(MyIndexReader ixreader)
	{
		this.ixreader=ixreader;
                p_ref = new HashMap<String, Double>();
	}
	
	/**
	 * Search for the topic with pseudo relevance feedback in 2017 spring assignment 4. 
	 * The returned results (retrieved documents) should be ranked by the score (from the most relevant to the least).
	 * 
	 * @param aQuery The query to be searched for.
	 * @param TopN The maximum number of returned document
	 * @param TopK The count of feedback documents
	 * @param alpha parameter of relevance feedback model
	 * @return TopN most relevant document, in List structure
	 */
	public List<Document> RetrieveQuery( Query aQuery, int TopN, int TopK, double alpha) throws Exception {	
		// this method will return the retrieval result of the given Query, and this result is enhanced with pseudo relevance feedback
		// (1) you should first use the original retrieval model to get TopK documents, which will be regarded as feedback documents
		// (2) implement GetTokenRFScore to get each query token's P(token|feedback model) in feedback documents
		// (3) implement the relevance feedback model for each token: combine the each query token's original retrieval score P(token|document) with its score in feedback documents P(token|feedback model)
		// (4) for each document, use the query likelihood language model to get the whole query's new score, P(Q|document)=P(token_1|document')*P(token_2|document')*...*P(token_n|document')
		
		
		//get P(token|feedback documents)
		String[] query = aQuery.GetQueryContent().split(" ");
	        //List<Document> doclist = new LinkedList<Document>();
		Set<Integer> docids = new HashSet<Integer>();
                List<Document> scorelist = new ArrayList<Document>();
		int[][] posting;
		int docid;
                // get all the union docs that contains the query term
		for (int i = 0; i < query.length; i++) {
			int[][] p = ixreader.getPostingList(query[i]);
			try {
				for (int j = 0; j < p.length; j++) {
					docids.add(p[j][0]);
					double temp = ixreader.CollectionFreq(query[i]) / totalterm;
					p_ref.put(query[i], temp);
				}
			} catch (Exception e) {
				System.out.println("token not exist: " + query[i]);
				docids.add(1);
				p_ref.put(query[i], 1.0 / totalterm);
			}
		}
		HashMap<String,Double> TokenRFScore=GetTokenRFScore(aQuery,TopK);
		int index = 0;
                HashMap<Integer, Doc> docinfo = new  HashMap<Integer, Doc>();
		docinfo = new HashMap<>();
		for (int i = 0; i < query.length; i++) {
		    posting = ixreader.getPostingList(query[i]);
		    if (posting == null) {
		        if (docinfo.containsKey(1)) {
                        Doc d = docinfo.get(1);
			d.detail.put(query[i], 1);
			docinfo.put(1, d);
                        } else
			    docinfo.put(1, new Doc(query[i], 1, ixreader.docLength(1)));
			    continue;
			}
			for (int j = 0; j < posting.length; j++) {
			    docid = posting[j][0];
			    if (docinfo.containsKey(docid)) {
				Doc doc = docinfo.get(docid);
				doc.detail.put(query[i], posting[j][1]);
				docinfo.put(docid, doc);
				} else
				docinfo.put(docid, new Doc(query[i], posting[j][1], ixreader.docLength(docid)));
			}
		}
                Iterator iter = docinfo.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    int d_id = (int)entry.getKey();
                    Doc val = (Doc)entry.getValue();
                    double tempscore = 1.0;
                    for (int i = 0; i < query.length; i++) {
			if (val.detail.containsKey(query[i]))
                            tempscore = tempscore * (alpha * getScore(val.detail.get(query[i]), val.doclength, p_ref.get(query[i])) + (1 - alpha) * TokenRFScore.get(query[i]));
			else
			    tempscore = tempscore * (alpha * getScore(0.0, val.doclength, p_ref.get(query[i]) + (1 - alpha) * TokenRFScore.get(query[i])));
			}
                    scorelist.add(new Document(Integer.toString(d_id) , ixreader.getDocno(d_id), tempscore));
                    }
                    Collections.sort(scorelist, new Comparator<Document>() {  
                    @Override  
                    public int compare(Document o1, Document o2) {  
                    if(o1.score()> o2.score()) {  
                        return 1;  
                    }else if (o1.score() < o2.score()){  
                        return -1;  
                    } 
                    else {  
                        return -1;
                    }  
                    }  
                    });  
		// sort all retrieved documents from most relevant to least, and return TopN
		List<Document> results = new ArrayList<Document>();
                for(int i = scorelist.size()-1; i>(scorelist.size()-1-TopN);i--){
                    results.add(scorelist.get(i));
                
                }
		
		return results;
	}
	
	public HashMap<String,Double> GetTokenRFScore(Query aQuery,  int TopK) throws Exception
	{
		// for each token in the query, you should calculate token's score in feedback documents: P(token|feedback documents)
		// use Dirichlet smoothing
		// save <token, score> in HashMap TokenRFScore, and return it
		HashMap<String,Double> TokenRFScore=new HashMap<String,Double>();
		List<Document> feedback = new QueryRetrievalModel(ixreader).retrieveQuery(aQuery, TopK);
		String[] query = aQuery.GetQueryContent().split(" ");
		double score;
		for (String q : query) {
			score = P_doc(q, feedback);
			TokenRFScore.put(q, score);
		}
		return TokenRFScore;
		
	}
        public double P_doc(String q, List<Document> d) throws IOException {
                double score = 0;
		int id = 0;
		int filelength = 0;
		int fcount = 0;
		double cf = p_ref.get(q);
		int[][] posting;
		Map<Integer, Integer> idset = new HashMap<>();
		// get file length of the feedback files
		// get term frequency in feedback files
		posting = ixreader.getPostingList(q);
		if (posting == null) 
			return 0.0;
		for (int i = 0; i < posting.length; i++) {
			idset.put(posting[i][0], posting[i][1]);
		}
		for (Document doc : d) {
			id = Integer.parseInt(doc.docid());
			if (idset.containsKey(id)) {
				int temp1 = ixreader.docLength(id);
				int temp2 = idset.get(id);
				fcount = fcount + temp2;
				filelength = filelength + temp1;
			}
		}
		score = (fcount + u * cf) / (filelength + u);
		return score;
        
            
        }
        public double getScore(double tdf, int dl, double cf) {
	    double score = (tdf / (dl + u)) + (cf * u / (dl + u));
	    return score;
	}
	
	
}