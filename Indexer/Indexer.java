package Indexer;
import java.io.*;
import java.net.URLDecoder;
//import java.util.AbstractQueue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Indexer{
	public static void main(String[] args){
				
		System.out.println("Starting");

		//Loops through each argument in passed through arguments and runs index on them
		for(String eachArg: args){
		    try{
//		    	URLDecoder.decode(path);
//		    	index(new File(URLDecoder.decode(eachArg)));
			   index(new File(eachArg));;
			}
			catch(Exception e){
				System.out.println(e.toString() + eachArg);
			}

		}
		System.out.println("Finished");
		
		
	}

	private static void index(File f) throws FileNotFoundException{
		String fileName = f.getPath();
//		System.out.println(fileName + " asdf");
		if(!f.exists()) System.out.println(fileName + " does not exist");
		
		// If the passed file is a directory, recursively call index on each file
		if(f.isDirectory()){
//			System.out.println(fileName + " is a directory*********/***********");

			for(File eachFile:f.listFiles()){
//				System.out.println("**********" + eachFile.getPath()+ "**********");
				index(eachFile);
				
			}
		}
		else{
			if(f.isFile() && fileName.contains(".java")){
				//Scanner to get lines from the passed in java source file
				Scanner fileScanner = new Scanner(f);
				//start currentChunk that is worked with as a CommentChunk because it is more often the first type of chunk in a file. 
				Chunk currentChunk = new CommentChunk();
				//Pace hold chunk for switching chunks
				Chunk temp;
//				Queue<Chunk> chunkQueue = new LinkedList<Chunk>();
				TokenTracker tt = new TokenTracker();
				ChunkQueueThread CQT = new ChunkQueueThread(tt);
				CQT.run();
			
				while(fileScanner.hasNext()){
					currentChunk.addLine(new StringBuffer(fileScanner.nextLine()));
					if (currentChunk.isComplete()){
						temp = currentChunk.nextChunk();
						CQT.append(currentChunk);
						currentChunk = temp;
						
					}
				}
				CQT.setComplete();
				while(CQT.isAlive());
				Database db = new Database();
				db.storeTokens(tt,fileName);
				
				Database db = Database.getInstance();
				db.storeTokens(tt,fileName);
				
				
				
			}
			else{
//				System.out.println(fileName + " is not supported");
			}
		}
	}
}
