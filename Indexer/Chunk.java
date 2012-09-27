package Indexer;
//Ryan comment
public abstract class Chunk {
	public class CommentChunk {

		public CommentChunk() {
			// TODO Auto-generated constructor stub
		}

	}
	private StringBuffer buffer;
	private StringBuffer content;

	public Chunk(){
		buffer = new StringBuffer();
		content = new StringBuffer();
	}
	protected Chunk(StringBuffer b){
		buffer = b;
		content = new StringBuffer();
	}
	public void addChar(char a){
		buffer.append(a);
	}
	public StringBuffer getBuffer(){
		return buffer;
	}


	public abstract boolean isComplete();
	public abstract void parse(TokenTracker t);


}
