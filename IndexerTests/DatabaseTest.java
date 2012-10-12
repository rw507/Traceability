package IndexerTests;
import Indexer.*;


public class DatabaseTest {
	public static void main(String[] args){
		System.out.println("Starting");
		Database dbTest = Database.getInstance();
		TokenTracker ttTest = new TokenTracker();

		String[] testCodeTokens = {
				"doctor",
				"patient",
				"room",
				"drug",
				"medicine",
				"doctor",
				"name",
				"birthday",
				"disease",
				"chronic",
				"monitor"
		};
		for(String s:testCodeTokens){
			ttTest.addCodeToken(s);
		}
		
		dbTest.storeTokens(ttTest, "test.java");
		dbTest.closeConnect();
		System.out.println("Done");
	}
}
