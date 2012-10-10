package Indexer;
//Ryan comment
//Chris Comment
public abstract class Chunk {
	
	protected StringBuffer buffer;
	protected StringBuffer content;

	public Chunk(){
		buffer = new StringBuffer();
		content = new StringBuffer();
	}
	protected Chunk(StringBuffer startBuffer){
		
		buffer = startBuffer;
		content = new StringBuffer();
	}
	public void addLine(StringBuffer line){
		buffer.append(line);
	}
	public StringBuffer getBuffer(){
		return buffer;
	}


	public abstract boolean isComplete();
	public abstract void parse(TokenTracker t);
	public abstract Chunk nextChunk();
	public abstract void test();

}
