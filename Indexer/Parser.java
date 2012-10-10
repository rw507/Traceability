package Indexer;

import java.util.LinkedList;
import java.util.List;

public class Parser {
	

	// removes camel case, punctuation, and splits words
	// the words are checked against the keyword/stopword hash
	// before being added to the wordList for futher testing.
	public static List<String> cleanseChunk(StringBuffer buffer){
		StopKeywordRemover stkwremover = StopKeywordRemover.getInstance();

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
				if(!stkwremover.removeWord(word.trim().toLowerCase()))
				  wordList.add(word.toLowerCase());
				beginWord = i;
			}


			//Checks for whitespace to indicate the end of a word
			// Also checks to see if the buffer still has not
			// been dumped by the end of the file
			//stores the words in lower case
			if((lastChar == ' ' && Character.isLetter(tempChar))){
				word = buffer.substring(beginWord, i);
				if(!stkwremover.removeWord(word.trim().toLowerCase()))
					  wordList.add(word.toLowerCase());
				beginWord = i;
			}
			else if(i==buffer.length()-1){
				word = buffer.substring(beginWord, i);
				if(!stkwremover.removeWord(word.trim().toLowerCase()))
					  wordList.add(word.toLowerCase());
			}



		}


		return wordList;
	} 
}

