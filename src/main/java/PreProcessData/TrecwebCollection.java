package PreProcessData;

import java.io.IOException;
import java.util.Map;
import Classes.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is for INFSCI 2140 in 2017
 *
 */
public class TrecwebCollection implements DocumentCollection {
	//you can add essential private methods or variables
	private File file = null;
        private BufferedReader input = null;
	// YOU SHOULD IMPLEMENT THIS METHOD
	public TrecwebCollection() throws IOException {
		// This constructor should open the file in Path.DataWebDir
		// and also should make preparation for function nextDocument()
		// you cannot load the whole corpus into memory here!!
                
                // initiate the BufferedReader to read file
                file = new File(Path.DataWebDir);
                input = new BufferedReader(new FileReader(file));
	}
	
	// YOU SHOULD IMPLEMENT THIS METHOD
	public Map<String, Object> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NT: the returned content of the document should be cleaned, all html tags should be removed.
		// NTT: remember to close the file that you opened, when you do not use it any more
		String key = "";
                String context = "";
                 // initiate the Map<String,Object> to save 
                Map<String,Object> map = new HashMap<String,Object>();
                boolean IsCollect = false;//use to judge if save the tempString ot not
                try{
                    
                    String tempString = null;
                    while ((tempString = input.readLine()) != null) { 
                        if(IsCollect){
                            context += tempString;
                        }
                        if(tempString.contains("<DOC>")){
                        String tempStringNo = null;
                        //use substring to seperate the number and <DOC></DOC>
                        tempStringNo = input.readLine();
                        String keystring = tempStringNo.substring(7, tempStringNo.length()-8);
                        key = keystring;
                        //System.out.println("key:"  + key);
                        }else if(tempString.contains("</DOCHDR>")){
                            IsCollect = true;
                        }else if(tempString.contains("</DOC>")){
                            //use Pattern and Matcher to filter html tag
                            String regEx_html = "<[^>]+>";
                            Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
                            Matcher m_html = p_html.matcher(context);  
                            context = m_html.replaceAll(""); // 过滤html标签
                            map.put(key, context.toCharArray());
                            //System.out.println("content:"  + context);
                            return map;
                        }else if(tempString.contains("</html>")){
                            IsCollect = false;
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
