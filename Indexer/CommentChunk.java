 package Indexer;

public class CommentChunk extends Chunk {
	
	//variables
	private boolean mc;
	private int j = 1;

	public CommentChunk() {
		// TODO Auto-generated constructor stub
	}

	public CommentChunk(StringBuffer b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isComplete() 
	{
		{
	        //int j = 1;
	        char c;
	        StringBuffer newBuffer = new StringBuffer();
	        
	        //If not in the middle of multi-line comment, look for "//" in 
	        //buffer. 
	        if (!mc) 
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
	                    if(b=='/') 
	                        // '//' was not found in commment there for comment 
	                        // chunk is complete and buffer will be added to 
	                        // content later
	                        j = i+2;
	                        break;
	                    
	                    if(b =='*')
	                    {
	                        // Begining of line starts a mutli-line comment, 
	                        // so set mc true and set j for next if statement 
	                        // will run and check for end of muli-line comment
	                        j= i+2;
	                        mc = true;
	                    }
	                    else{
	                        // a comment start was not found, therefor this line
	                        // is not a comment
	                        return true;
	                    }
	        
	                }
	                else
	                     // a comment start was not found, therefor this line
	                     // is not a comment
	                    return true;
	               }
	            }
	        }
	        if(mc)
	        {
	            // x and y are characters being checked for end of muli-line
	            // comment
	            char x = buffer.charAt(j-1);
	            char y = buffer.charAt(j);
	        
	            //look through each char in buffer
	            for(;j<buffer.length()-1;x=y, y = buffer.charAt(j))
	            {
	                
	                if(mc){
	                //if still mid-comment, add y to content and check to see if
	                // end of multi-line comment
	                    content.append(y);
	                    if(x=='*' && y=='/')
	                        mc = false;
	                }
	                else
	                //no in multi-line comment, so add remander of line to newbuffer         
	                    newBuffer.append(y); 
	               
	               
	            }
	            //sets buffer to newBuffer for passing to code chunk later
	            // if its empty, then its ready for next line
	            buffer = newBuffer;
	            if(!mc)
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


	@Override
	public void parse(TokenTracker t) {
		// TODO Auto-generated method stub
		
	}

	public Chunk nextChunk() {
		// TODO Auto-generated method stub
		return null;
	}

}
