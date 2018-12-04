package PreProcessData;
import Classes.Path;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StopWordRemover {
	//you can add essential private methods or variables in 2017.
	private File file = null;
        private BufferedReader input = null;
        private List<String> stopWList = new ArrayList<String>();// initiate a list to save stopwords
	public StopWordRemover( ) {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		// address of stopword.txt should be Path.StopwordDir
                
                // initiate the BufferedReader to read file
                file = new File(Path.StopwordDir);
                 try {
                input = new BufferedReader(new FileReader(file));
                 } catch (FileNotFoundException ex) {
                        Logger.getLogger(StopWordRemover.class.getName()).log(Level.SEVERE, null, ex);
                    }
                // add all the words in the file to stopWList
                try{
                    String tempString = null;
                    while ((tempString = input.readLine()) != null) { 
                        stopWList.add(tempString);
                        
                        }
                    input.close();
                    }catch (IOException e) {
                    e.printStackTrace();
                }
                
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword( char[] word ) {
		// return true if the input word is a stopword, or false if not
                //translate char[] to string
                String temp = "";
                for(int i = 0; i<word.length;i++){
                    temp+=word[i];
                }
                //judge if word is a stopword
                if(stopWList.contains(temp)){
                    return true;
                }else{
		    return false;
                }
	}
}
