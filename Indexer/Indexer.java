package Indexer;
import java.io.*;
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
				index(new File(eachArg));
			}
			catch(Exception e){
				System.out.println(e.toString());
			}

		}
		System.out.println("Finished");
	}

	private static void index(File f) throws FileNotFoundException{
		String fileName = f.getPath();
		
		// If the passed file is a directory, recursively call index on each file
		if(f.isDirectory()){
//			System.out.println(fileName + " is a directory********************");

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
				Queue<Chunk> chunkQueue = new LinkedList<Chunk>();

				while(fileScanner.hasNext()){
					currentChunk.addLine(new StringBuffer(fileScanner.nextLine()));
					if (currentChunk.isComplete()){
						temp = currentChunk.nextChunk();
						chunkQueue.add(currentChunk);
						currentChunk = temp;
						
					}
				}
				
				
			}
			else{
//				System.out.println(fileName + " is not supported");
			}
		}
	}
}



//
//public class Indexer {
//	public static void main(String [] args){
//
//		//Loop through each argument, run recursive function index(File)
//		for (String s: args){
//			try{
//				index(new File(s));
//			}
//			catch(Exception e){
//
//			}
//		}
//	}
//
//
//	//Recurses each file in directory
//	//indexes file
//	private static void index(File f){
//		if(f.isDirectory()){
//			for(File s:f.listFiles()){
//				index(s);
//			}
//		}
//		if(f.isFile()){
//			try{
//				Scanner fileScanner = new Scanner(f);
//				Chunk currentChunk = new CommentChunk();
//				Chunk tempChunk;
//				Queue<Chunk> chunkQueue = new LinkedList<Chunk>();
//				
//				//Take each line and give to current chunk
//				
//				while(fileScanner.hasNext()){
//					currentChunk.addLine(new StringBuffer(fileScanner.nextLine()));
//					//If current chunk is complete, get the new chunk and put current chunk in queue
//					if(currentChunk.isComplete()){
//						tempChunk = currentChunk.nextChunk();
//						chunkQueue.add(currentChunk);
//						currentChunk = tempChunk;
//					}
//				}
//			}
//			catch(Exception e){
//
//			}
//
//		}
//	}
//}	