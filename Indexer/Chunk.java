package Indexer;
//Ryan comment
//Chris Comment
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
		parseBuffer();
	}
		public void addChar(char a){
		buffer.append(a);
		parseBuffer();
	}
			public StringBuffer getBuffer(){
		return buffer;
	}
			
			
	public abstract boolean isComplete();
	public abstract void parseBuffer();
	
	
}
