package Indexer;

public class CommentChunk extends Chunk {

	public CommentChunk() {
		// TODO Auto-generated constructor stub
	}

	public CommentChunk(StringBuffer b) {
		super(b);
		// TODO Auto-generated constructor stub
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

	public Chunk nextChunk() {
		// TODO Auto-generated method stub
		return null;
	}

}
