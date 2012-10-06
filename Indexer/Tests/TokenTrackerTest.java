package Indexer.Tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class TokenTrackerTest {

		
		private HashMap<String, Integer> code;
		private HashMap<String, Integer> comment;
		
		public TokenTrackerTest(){
			code = new HashMap<String, Integer>();
			comment = new HashMap<String, Integer>();
		}
		
		/*
		 * takes a token and adds it to the code hash map as a key
		 * if the key already exists its value is incremented
		 * otherwise the value is 1
		 */
		public void addCodeToken(String token){
			if(code.containsKey(token))
			{	Integer i = code.get(token);
				code.put(token,++i);
			}
			else
				code.put(token,1);			
		}
		
		/*
		 * takes a token and adds it to the comment hash map as a key
		 * if the key already exists its value is incremented
		 * otherwise the value is 1
		 */
		public void addCommentToken(String token){
			if(comment.containsKey(token))
			{	Integer i = comment.get(token);
				comment.put(token,++i);
			}
			else
				comment.put(token,1);		
		}
		
		/*
		 * returns a Set of keys(tokens) in the code hash map
		 */
		public Set<String> getCodeKeys(){
			return code.keySet();
		}
		
		/*
		 * returns a Set of keys(tokens) in the comment hash map
		 */
		public Set<String> getCommentKeys(){
			return comment.keySet();
		}
		
		/*
		 * returns the number of time a token was found
		 * in the code
		 */
		public int getCodeTokCount(String token){
			if(code.containsKey(token))
				return code.get(token);
			else
				return 0;
			
		}
		
		/*
		 * returns the number of time a token was found
		 * in the comments
		 */
		public int getCommentTokCount(String token){
			if(comment.containsKey(token))
				return comment.get(token);
			else
				return 0;
		}


public static void main(String[] args)
{
	
	Set codeSet;
	Set commentSet;
	TokenTrackerTest T = new TokenTrackerTest();
	T.addCodeToken("Patient");
	T.addCodeToken("Patient");
	T.addCodeToken("Patient");
	T.addCodeToken("Patient");
	T.addCodeToken("bill");
	T.addCodeToken("cents");
	T.addCommentToken("Doctor");
	T.addCommentToken("Doctor");
	T.addCommentToken("Doctor");
	T.addCommentToken("Doctor");
	T.addCommentToken("med");
	T.addCommentToken("pill");
	codeSet = T.getCodeKeys();
	commentSet = T.getCommentKeys();
	int patientCount = T.getCodeTokCount("Patient");
	int drugCount = T.getCodeTokCount("Drug");
	int DoctorCount = T.getCommentTokCount("Doctor");
	System.out.println("Patient " + patientCount + "Drug " + drugCount + "Doctor " + DoctorCount);
	System.out.println("Code set");
	Iterator codeIt = codeSet.iterator();
	Iterator commentIt = commentSet.iterator();
	while (codeIt.hasNext())
	{
		System.out.println(codeIt.next());
	}
	System.out.println("Comment set");
	while (commentIt.hasNext())
	{
		System.out.println(commentIt.next());
	}
	
}

}

