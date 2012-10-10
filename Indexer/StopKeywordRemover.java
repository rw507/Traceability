package Indexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/*
 * This class builds a hash for Stop Words and keywords
 *  -The program will create an object of this class
 *    then pass it words to test whether or not to remove
 *    the word from the main text body
 * 
 *  - This should only be instantiated once, and could be improved by 
 *     adding code to force it as a singleton
 */

public class StopKeywordRemover {
     
	private Set<String> stop_keywords = new HashSet<String>();
	private File inF = null;
	private Scanner fScan = null;
	
	
    //Default constructor builds the 'words to be removed' hash table
	public StopKeywordRemover(){
	
       try{
		buildHash();
       }
       catch(FileNotFoundException fnfE){}
	}
	
	
	private void buildHash() throws FileNotFoundException{
		
			inF = new File("englishStopWords.txt");
		    fScan = new Scanner(inF);
		    addtoHash();
			
			
			inF = new File("javaKeywords.txt");
			fScan = new Scanner(inF);
			addtoHash();
			
	}
	
	
	//made this its own method to cut down on repetition
	private void addtoHash(){
		
		while(fScan.hasNextLine()){
			stop_keywords.add(fScan.nextLine());
		}
		
	}
	
	
	public boolean removeWord(String word){
		
		if(stop_keywords.contains(word))
			return true;
	
		return false;
	}
}
