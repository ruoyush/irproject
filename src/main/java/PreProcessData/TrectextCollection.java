package PreProcessData;

import Classes.Job;
import java.io.IOException;
import java.util.Map;
import Classes.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

/**
 * This is for INFSCI 2140 in 2017
 *
 */
public class TrectextCollection implements DocumentCollection {
	//you can add essential private methods or variables
	private File file = null;
        private BufferedReader input = null;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrectextCollection() throws IOException {
		// This constructor should open the file in Path.DataTextDir
		// and also should make preparation for function nextDocument()
		// you cannot load the whole corpus into memory here!!
                
                // initiate the BufferedReader to read file
                file = new File(Path.DataTextDir);
                input = new BufferedReader(new FileReader(file));
                
		
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NTT: remember to close the file that you opened, when you do not use it any more
		String key = "";
                String jobtitle = "";
                String location = "";
                String company = "";
                String content = "";
                // initiate the Map<String,Object> to save 
                Map<String,Object> map = new HashMap<String,Object>();
                boolean IsCollect = false;//use to judge if save the tempString ot not
                try{
                    
                    String tempString = null;
                    //int line = 1;
                    while ((tempString = input.readLine()) != null) {

                        if(tempString.contains("<DOC>")){
                        //find out the document's number
                        
                        //use split to seperate the number and <DOC></DOC>
                        String[] sourceStrArray = tempString.split(" ");
                        key = sourceStrArray[1];
                        //System.out.println("key:"  + key);
                        }else if(tempString.contains("<JOBTITLE>")){
                           
                            jobtitle=tempString.substring(12,(tempString.length()-13));
                        }else if(tempString.contains("<LOCATION>")){
                           
                            location=tempString.substring(11,(tempString.length()-12));
                        }else if(tempString.contains("<COMPANY>")){
                           
                            company=tempString.substring(10,(tempString.length()-11));
                        }else if(tempString.contains("<SUMMARY>")){
                           
                            content=tempString.substring(10,(tempString.length()-11));
                        }else if(tempString.contains("</SUMMARY>")){
                            //When read </doc>, stop reading and return map
                            Job temp = new Job(jobtitle,company,location,content);
                            //map.put(key, content.toCharArray());
                            map.put(key, temp);
                            //System.out.println("content:"  + context);
                            return map;
                        }

                       
                        //System.out.println("line " + line + ": " + tempString);
                        //line++;
                    }
                }catch (IOException e) {
                e.printStackTrace();
            }
                //close the file in the end
                input.close();
                return null;
              
		
		
	}
}