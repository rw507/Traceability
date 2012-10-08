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
		StringBuffer newBuffer = new StringBuffer();
		boolean completed = false;
		char x = buffer.charAt(0);
		char y = buffer.charAt(1);
		for(;i<buffer.length();i++,x=y,y=buffer.charAt(i)){
			
			if(x == '/' && (y == '/' || y=='*')){
				completed = true;
				newBuffer.append(x);
				newBuffer.append(y);
				
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
