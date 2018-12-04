package SearchLucene;

import java.util.ArrayList;

import Classes.Query;
import PreProcessData.StopWordRemover;
import PreProcessData.WordNormalizer;
import PreProcessData.WordTokenizer;

public class ExtractQuery {

	ArrayList<Query> queries;
        public Query query;
        static int tidcount = 0;

	int idx = 0;

	public ExtractQuery() {
		// you should extract the 4 queries from the Path.TopicDir
		// NT: the query content of each topic should be 1) tokenized, 2) to
		// lowercase, 3) remove stop words, 4) stemming
		// NT: you can simply pick up title only for query, or you can also use
		// title + description + narrative for the query content.
		queries = new ArrayList<>();
		Query aQuery = new Query();
		aQuery.SetTopicId("901");
		//aQuery.SetQueryContent("hong kong econom singapor");
                aQuery.SetQueryContent("java develop");
		queries.add(aQuery);
		aQuery = new Query();
		aQuery.SetTopicId("902");
		aQuery.SetQueryContent("data");
		queries.add(aQuery);
		aQuery = new Query();
		aQuery.SetTopicId("903");
		aQuery.SetQueryContent("c#");
		queries.add(aQuery);
//		aQuery = new Query();
//		aQuery.SetTopicId("904");
//		aQuery.SetQueryContent("progress dysphagia");
//		queries.add(aQuery);
	}
        public ExtractQuery(String str) {
		// you should extract the 4 queries from the Path.TopicDir
		// NT: the query content of each topic should be 1) tokenized, 2) to
		// lowercase, 3) remove stop words, 4) stemming
		// NT: you can simply pick up title only for query, or you can also use
		// title + description + narrative for the query content.
		//queries = new ArrayList<>();
                String temp = "";
                str+=" ";
                StopWordRemover stopwordRemover = new StopWordRemover();
                WordNormalizer normalizer = new WordNormalizer();
                WordTokenizer tokenizer = new WordTokenizer(str.toCharArray());

			// initiate a word object, which can hold a word
			char[] word = null;

			// process the document word by word iteratively
			while ((word = tokenizer.nextWord()) != null) {
				// each word is transformed into lowercase
				word = normalizer.lowercase(word);

				// filter out stopword, and only non-stopword will be written
				// into result file
				if (!stopwordRemover.isStopword(word)){
					temp+=(normalizer.stem(word) + " ");
                                       
                                }
					//stemmed format of each word is written into result file	
			}
               
//                char[] norstr=wnormalizer.lowercase(str.toCharArray());
//                str=String.valueOf(norstr);
		Query aQuery = new Query();
		aQuery.SetTopicId(String.valueOf(ExtractQuery.tidcount));
                ExtractQuery.tidcount++;
                aQuery.SetQueryContent(temp);
		query = aQuery;
		
	}

	public boolean hasNext() {
		if (idx == queries.size()) {
			return false;
		} else {
			return true;
		}
	}

	public Query next() {
		return queries.get(idx++);
	}

}
