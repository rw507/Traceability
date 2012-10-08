package Indexer;

public class CodeChunk extends Chunk {
	public CodeChunk(){
		super();
	}
	public CodeChunk(StringBuffer startBuffer){
		super(startBuffer);
	}

	@Override
	public StringBuffer getBuffer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComplete() {
		int i = 1;
		
		char x = buffer.charAt(0);
		char y = buffer.charAt(1);
		for(;i<buffer.length();i++,x=y,y=buffer.charAt(i)){
			
			if(x == '/' && (y == '/' || y=='*')){
			
				buffer = buffer.delete(0,i-2);
				return true;
				
			}
		}
		return false;
	}


	@Override
	public void parse(TokenTracker t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chunk nextChunk() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

}
