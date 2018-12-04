package PreProcessData;
import Classes.Stemmer;

/**
 * This is for INFSCI 2140 in 2017
 * 
 */
public class WordNormalizer {
	//you can add essential private methods or variables
	
	// YOU MUST IMPLEMENT THIS METHOD
	public char[] lowercase( char[] chars ) {
		//transform the uppercase characters in the word to lowercase
                //using ASCII to transform the uppercase characters to lowercase
                for(int i = 0; i<chars.length;i++){
                    if(((int)chars[i]>64)&&((int)chars[i]<91)){
                        int temp = (int)chars[i]+32;
                        chars[i] = (char)temp;
                    }
                }
		return chars;
	}
	
	public String stem(char[] chars)
	{
		//use the stemmer in Classes package to do the stemming on input word, and return the stemmed word
                Stemmer s = new Stemmer();
		s.add(chars, chars.length);
		s.stem();
		String str=s.toString();
		return str;
	}
	
}
