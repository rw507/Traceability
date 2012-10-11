package Indexer;
import java.lang.StringBuffer;
import java.util.LinkedList;
//import java.io.*;
import java.util.List;

public class CommentChunk extends Chunk {

	//variables
	private boolean multiLineComment = false;
	//	private int j = 1;


	//Default Constructor
	public CommentChunk() {
		super();
	}

	//Constructor when being previous Chunk is being passed.
	//Picks up leftover buffer of prev Chunk
	public CommentChunk(StringBuffer b) {
		super(b);
	}
	@Override
	public void test(){
		System.out.println("TEST");
	}
	
	public StringBuffer printBuffer(){
		return buffer;
	}
	
	@Override
	public boolean isComplete() 
	{
		{
			int j = 1;
			//If not in the middle of multi-line comment, look for "//" in 
			//buffer. 
			if (!multiLineComment) 
			{
				// a and b are the two characters of the buffer being checked
				char a = buffer.charAt(0);
				char b = buffer.charAt(1);
				// boolean isComment = true;

				//				content.append(b);
				for (int i =1; i<buffer.length()-1 && !multiLineComment;i++,a=b,b=buffer.charAt(i))
				{

					System.out.print("   |" + a +b+ "|   ");
					if(a == ' '){

						continue;
					}
					if(a == '/')
					{
						if(b=='/') {
							// '//' was not found in comment there for comment 
							// chunk is complete and buffer will be added to 
							// content later

							j = i+2;
							break;
						}
						if(b == '*')
						{
							// Beginning of line starts a mutli-line comment, 
							// so set mc true and set j for next if statement 
							// will run and check for end of multi-line comment
							j= i+2;
							multiLineComment = true;
							//							System.out.print("  ***   ");
							break;
							//							break;
						}
						else{
							// a comment start was not found, therefore this line
							// is not a comment
							//							System.out.print("   a   ");
							return true;
						}
					}
					else{
						// a comment start was not found, therefore this line
						// is not a comment
						//						System.out.print("   b   ");
						return true;
					}
				}
			}

			if(multiLineComment)
			{
				// x and y are characters being checked for end of muli-line
				// comment
				char x = buffer.charAt(j-1);
				char y = buffer.charAt(j);

				//				content.append(x);
				StringBuffer newBuffer = new StringBuffer();
				//look through each char in buffer
				for(;j<buffer.length();j++,x=y )
				{
					
						
					y = buffer.charAt(j);
					
					if(x == '*' && y=='/'){
						buffer = buffer.delete(0, j+1);
						//						System.out.print("   c   ");
						return true;
					}
					content.append(x);
					
				}
				content.append(y);
				//sets buffer to newBuffer for passing to code chunk later
				// if its empty, then its ready for next line
				buffer = newBuffer;
				if(multiLineComment)
					return false;
			}
			else
			{
				for(int i = j-1;i<buffer.length();i++)
				{

					//line was a single line comment, so add the rest of line to
					//content
					content.append(buffer.charAt(i));
				}
			}

			return false;
		}

	}
	@Override
	public void parse(TokenTracker t) {
		//remove numbers and punctuation and splits the string buffer into a linked list of strings
		List<String> wordList = new LinkedList<String>();

		wordList = Parser.cleanseChunk(buffer);

		//		int beginWord = 0, endWord;
		//        boolean buildingWord = false;
		//        for(int i=0; i<buffer.length(); ++i)
		//        {
		//        	char tempChar = buffer.charAt(i);
		//        	
		//            if(!Character.isLetter(tempChar))
		//            {
		//            	if(buildingWord == true)
		//            	{
		//            		endWord = i-1;
		//            		if(endWord - beginWord >= 1)
		//            		{
		//            			wordList.add(buffer.substring(beginWord, endWord));
		//            			buildingWord = true;
		//            		}
		//            	}
		//            	buffer.setCharAt(i, ' ');
		//                
		//            }
		//            else if(buildingWord == false)
		//            {
		//            	beginWord = i;
		//            }
		// 
		//        }
		// TODO split words ie helloWorld -> hello World
		// TODO set everything to lower case
		// TODO split into individual strings
		// TODO remove stop words
		// TODO stem
	}

	//Used when a CommentChunk is complete. If there is a leftover buffer, it will contain code, therefore
	//it must be passed to the new CodeChunk
	public Chunk nextChunk() {
		return new CodeChunk(buffer);
	}

}
