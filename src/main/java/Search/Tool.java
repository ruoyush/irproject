package Search;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

import Classes.*;
import IndexingLucene.*;
import PseudoRFSearch.PseudoRFRetrievalModel;
import SearchLucene.ExtractQuery;
import SearchLucene.QueryRetrievalModel;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mac
 */
public class Tool {
    	public static ArrayList<String> DirectSearch(String str) throws Exception {
		// Open index
		ArrayList<String> resultlist = new ArrayList<>();
		MyIndexReader ixreader = new MyIndexReader();
		// Initialize the MyRetrievalModel
		QueryRetrievalModel model = new QueryRetrievalModel(ixreader);
		// Extract the queries
		ExtractQuery query = new ExtractQuery(str);
		
		long startTime = System.currentTimeMillis();
		Query aQuery = query.query;
//		System.out.println(aQuery.GetTopicId() + "\t" + aQuery.GetQueryContent());
		// conduct retrieval on the index for each topic, and return top 20 documents
		List<Document> results = model.retrieveQuery(aQuery, 20);
		if (results  != null) {
			int rank = 1;
			for (Document result : results) {
//				System.out.println(aQuery.GetTopicId() + " Q0 " + result.docno() + " " + rank + " " + result.score() + " MYRUN");
                                resultlist.add(result.docno());
										//.put(result.docno(), rank);
				rank++;
			}
		}
			
		
		long endTime = System.currentTimeMillis(); // end time of running code
//		System.out.println("\n\n query search time: " + (endTime - startTime) / 60000.0 + " min");
		ixreader.close();
                return resultlist;
	}
        public static ArrayList<String> PseudoRFRetrievalSearch(String str) throws Exception {
		//HashMap<String,Integer> resultmap = new HashMap<String,Integer>();
			ArrayList<String> resultlist = new ArrayList<>();
		// Open index, initialize the pseudo relevance feedback retrieval model,and extract queries
		MyIndexReader ixreader = new MyIndexReader();
		PseudoRFRetrievalModel PRFSearchModel = new PseudoRFRetrievalModel(ixreader);
		ExtractQuery query = new ExtractQuery(str);
		
		// begin search
		long startTime = System.currentTimeMillis();
		
		Query aQuery = query.query;
		List<Document> results = PRFSearchModel.RetrieveQuery(aQuery, 20, 30, 0.4);
//                System.out.println(aQuery.GetTopicId() + "\t" + aQuery.GetQueryContent());
		if (results != null) {
			int rank = 1;
			for (Document result : results) {
//				System.out.println(aQuery.GetTopicId() + " Q0 " + result.docno() + " " + rank + " "
//						   + result.score() + " MYRUN");
                                //resultmap.put(result.docno(), rank);
				resultlist.add(result.docno());
				rank++;
			}
		}
		
		long endTime = System.currentTimeMillis(); 
		
		// output running time
//		System.out.println("\n\n query search time: " + (endTime - startTime) / 60000.0 + " min");
		ixreader.close();
                return resultlist;
	}
}
