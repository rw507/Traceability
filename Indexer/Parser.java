package Indexer;



import java.util.LinkedList;
import java.util.List;



public class Parser {
	//private static Stemmer s = null;

	// removes camel case, punctuation, and splits words
	// the words are checked against the keyword/stopword hash
	// before being added to the wordList for futher testing.
	public static List<String> cleanseChunk(StringBuffer buffer){
		StopKeywordRemover stkwremover = StopKeywordRemover.getInstance();
//		s = new Stemmer();


		List<String> wordList = new LinkedList<String>();

		int beginWord = 0;
		char lastChar = ' ';
		char tempChar = ' ';
		String word = " ";

		for(int i=1; i<buffer.length(); i++)
		{


			lastChar = buffer.charAt(i-1);
			tempChar = buffer.charAt(i);


			//replaces non letter characters with whitespace
			if(!Character.isLetter(tempChar))
			{
				buffer.setCharAt(i, ' ');
			}


			//breaks Camel case words into two words 
			//  and stores as a lower case word
			if(Character.isUpperCase(tempChar) && Character.isLowerCase(lastChar)){
				word = buffer.substring(beginWord, i);
				if(!stkwremover.removeWord(word.trim().toLowerCase())){
					//System.out.print("Word before stem 1: " + word);

					word = stem(word.trim().toLowerCase());
					//System.out.println(" Word after Stem: "+word);

					wordList.add(word.trim().toLowerCase());
				}
				beginWord = i;
			}


			//Checks for whitespace to indicate the end of a word
			// Also checks to see if the buffer still has not
			// been dumped by the end of the file
			//stores the words in lower case
			if((lastChar == ' ' && Character.isLetter(tempChar))){
				word = buffer.substring(beginWord, i);
				if(!stkwremover.removeWord(word.trim().toLowerCase())){
					//System.out.print("Word before stem 2: " + word);
					word = stem(word.trim().toLowerCase());
					wordList.add(word.trim().toLowerCase());
					//System.out.println(" Word after Stem: "+word);

				}
				beginWord = i;
			}
			else if(i==buffer.length()-1){
				word = buffer.substring(beginWord, i+1);
				if(!stkwremover.removeWord(word.trim().toLowerCase())){
					//System.out.print("Word before stem 3: " + word);
					word = stem(word.trim().toLowerCase());
					//System.out.println(" Word after Stem: "+word);
					wordList.add(word.trim().toLowerCase());
				}
			}



		}


		return wordList;
	} 

	public static String stem(String word){
		
		Stemmer s = new Stemmer();
//		char[] array = word.toCharArray();
	
		for(char c:word.toCharArray()){

			s.add(c);
		}
//		s.add(word.toCharArray(), word.length());
//		System.out.print(s.getResultBuffer());
	
		s.stem();
		for(int i = 0;i<s.getResultLength();i++){
			System.out.print(s.getResultBuffer()[i]);
		}

//		}
		//array = s.getResultBuffer();
		//		for(int i = 0;i<s.getResultLength();i++){
		//			System.out.print(array[i]);
		//		}

		//System.out.print("||" + s.toString() + "||");
		return s.toString();
	}
}

