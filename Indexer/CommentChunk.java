package Indexer;
import java.lang.StringBuffer;
//import java.io.*;

public class CommentChunk extends Chunk {

	//variables
	private boolean multiLineComment =false;
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
	@Override
	public boolean isComplete() 
	{
		{
			int j = 1;
//			char c;

			//	 		StringBuffer newBuffer = new StringBuffer();
			//			StringBuffer newBuffer;

			//If not in the middle of multi-line comment, look for "//" in 
			//buffer. 
			if (!multiLineComment) 
			{
				// a and b are the two characters of the buffer being checked
				char a = buffer.charAt(0);
				char b = buffer.charAt(1);
				// boolean isComment = true;

				content.append(b);
				for (int i =0;i<buffer.length()-1;i++,a=b,b=buffer.charAt(i))
				{
					// if(!isComment){
					//     newBuffer.append(b);

					//  }
					//  else{
					if(a == ' ') 
						continue;
					if(a == '/')
					{
						if(b=='/') {
							// '//' was not found in comment there for comment 
							// chunk is complete and buffer will be added to 
							// content later
							j = i+2;
							break;
						}
						if(b =='*')
						{
							// Beginning of line starts a mutli-line comment, 
							// so set mc true and set j for next if statement 
							// will run and check for end of multi-line comment
							j= i+2;
							multiLineComment = true;
						}
						else{
							// a comment start was not found, therefore this line
							// is not a comment
							return true;
						}

					}
					else
						// a comment start was not found, therefore this line
						// is not a comment
						return true;
				}
			}

			if(multiLineComment)
			{
				// x and y are characters being checked for end of muli-line
				// comment
				char x = buffer.charAt(j-1);
				char y = buffer.charAt(j);

				StringBuffer newBuffer = new StringBuffer();
				//look through each char in buffer
				for(;j<buffer.length()-1;x=y, y = buffer.charAt(j))
				{

					if(multiLineComment){
						//if still mid-comment, add y to content and check to see if
						// end of multi-line comment
						content.append(y);
						if(x=='*' && y=='/')
							multiLineComment = false;
					}
					else{
						//no in multi-line comment, so add remainder of line to newbuffer         
						newBuffer.append(y); 
					}

				}
				//sets buffer to newBuffer for passing to code chunk later
				// if its empty, then its ready for next line
				buffer = newBuffer;
				if(!multiLineComment)
					return true;
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
		// TODO Auto-generated method stub

	}

	//Used when a CommentChunk is complete. If there is a leftover buffer, it will contain code, therefore
	//it must be passed to the new CodeChunk
	public Chunk nextChunk() {
		return new CodeChunk(buffer);
	}

}
