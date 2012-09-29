package Indexer;


/*
 * This TokenTracker class holds the final keywords and the count of each
 * for the comments and the code
 * 
 */
import java.util.HashMap;
import java.util.Set;


public class TokenTracker {
	
	private HashMap<String, Integer> code;
	private HashMap<String, Integer> comment;
	
	public TokenTracker(){
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
	public Set getCodeKeys(){
		return code.keySet();
	}
	
	/*
	 * returns a Set of keys(tokens) in the comment hash map
	 */
	public Set getCommentKeys(){
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

}
