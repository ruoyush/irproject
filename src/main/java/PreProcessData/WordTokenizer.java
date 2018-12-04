package PreProcessData;

import java.util.ArrayList;
import java.util.List;

/**
 * This is for INFSCI 2140 in 2017 fall
 * 
 * TextTokenizer can split a sequence of text into individual word tokens.
 */
public class WordTokenizer {
	//you can add essential private methods or variables
	private List<Character> content = new ArrayList<Character>();
        private int count;
	// YOU MUST IMPLEMENT THIS METHOD
	public WordTokenizer( char[] texts ) {
		// this constructor will tokenize the input texts (usually it is a char array for a whole document)
                count = 0;
                int length = texts.length;
                for(int i = 0; i < length;i++){
                    // only add letters and spaces
                    if(Character.isLetter(texts[i])){
                        content.add(texts[i]);
                    }else if(texts[i]==' '){
                        content.add(texts[i]);
                    
                    }else if(texts[i]=='#'){
                        content.add(texts[i]);  
                    }else if(texts[i]=='+'){
                        content.add(texts[i]);
                    }else if(((int)texts[i]>32)&&((int)texts[i]<48)){//when read punctuation add a space if there is no space after it
                        if(i<length-1){
                            if(texts[i+1]!=' '){
                                char temp = ' ';
                                content.add(temp);
                            }
                        }
                    }
                }
                
                
	}
	
	// YOU MUST IMPLEMENT THIS METHOD
	public char[] nextWord() {
		// read and return the next word of the document
		// or return null if it is the end of the document
                int start = count;
                int length = content.size();

                while(count<length){
                    if(content.get(count)!=' '){//add letters to a word when there is no space
                        Character temp = content.get(count);
                        count++;
                    }else if(count == start){//when the first char is space, skip it
                        count ++;
                        start = count;
                    }else{
                        //output
                        count++;
                        char[] tempA = new char[count-start-1];
                        int tempL = count-start-1;
                        for(int c = 0; c < tempL; c++){
                            tempA[c]=content.get(start);
                            start++;
                        }
                        //System.out.println(tempA[0]);
                        return tempA;
                    }
                }
		return null;
	}
	
}
