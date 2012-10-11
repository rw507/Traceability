package IndexerTests;
import Indexer.*;
public class ChunkTest {
	public static void main(String[] args){
		
		String test1 = "//its a comment for stuff"; 	// true
		String test2 = "test /n more /n other //stuff;";	//false
		String test3 = "more code // comment \n //more comment"; 	//true
		String test4 = "int y = x/y;";		//false
		String test5 = "/*asdf";		//true
		String test6 = "You know */  code"; //false
		String test7 = "/*asdf \n  asdf \n asdf*/"; //true
		
		
		StringBuffer testBuffer = new StringBuffer();
		testBuffer.append(test1);
		testBuffer.append(test2);
		testBuffer.append(test3);
		testBuffer.append(test4);
		testBuffer.append(test5);
		testBuffer.append(test6);
		testBuffer.append(test7);
		
		Chunk currentChunk = new CommentChunk(testBuffer);
		Chunk temp = null;
		
		for(int i=0;i<7;i++){
		 if (currentChunk.isComplete()){
			System.out.print("Done");
			temp = currentChunk.nextChunk();
			//CQT.append(currentChunk);
			currentChunk = temp;
		}
		
		}
//		System.out.println(test1 + " -> " + new CodeChunk(new StringBuffer(test1)).isComplete());
//		System.out.println(test2 + " -> " + new CodeChunk(new StringBuffer(test2)).isComplete());
//		System.out.println(test3 + " -> " + new CodeChunk(new StringBuffer(test3)).isComplete());
//		System.out.println(test4 + " -> " + new CodeChunk(new StringBuffer(test4)).isComplete());
//		System.out.println(test5 + " -> " + new CodeChunk(new StringBuffer(test5)).isComplete());
//		System.out.println(test6 + " -> " + new CodeChunk(new StringBuffer(test6)).isComplete());
//		System.out.println(test7 + " -> " + new CodeChunk(new StringBuffer(test7)).isComplete());
	}
}
