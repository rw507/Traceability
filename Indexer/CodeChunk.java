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
		// TODO Auto-generated method stub
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

}
