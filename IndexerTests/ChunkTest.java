package IndexerTests;
import Indexer.*;
public class ChunkTest {
	public static void main(){
		String test1 = "//Hasdf"; 	//false
		String test2 = "/*asdf*/";	//true
		String test3 = "/*adf"; 	//false
		String test4 = "asdf";		//true
		String test5 = "/asdf";		//true
		String test6 = "/*asdf \n  asdf"; //false
		
		
		StringBuffer testBuffer;
		System.out.println(test1 + " -> " + new CommentChunk(new StringBuffer(test1)));
		System.out.println(test2 + " -> " + new CommentChunk(new StringBuffer(test2)));
		System.out.println(test3 + " -> " + new CommentChunk(new StringBuffer(test3)));
		System.out.println(test4 + " -> " + new CommentChunk(new StringBuffer(test4)));
		System.out.println(test5 + " -> " + new CommentChunk(new StringBuffer(test5)));
		System.out.println(test6 + " -> " + new CommentChunk(new StringBuffer(test6)));
		
	}
}
