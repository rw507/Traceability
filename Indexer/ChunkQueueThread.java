package Indexer;
//
//import java.lang.Thread;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ChunkQueueThread extends Thread{
    public boolean complete;
    private BlockingQueue<Chunk> queue = new LinkedBlockingQueue<Chunk>();
    private static long timeOut = 1000;
     
    public ChunkQueueThread(){
        complete = false;
    }

    public void run(){
        Chunk current;
        
        while(!(complete && queue.isEmpty())){
        	 System.out.print(complete);
             System.out.print(":" + queue.isEmpty() + "\n");
        	
          try{
        	 if(!queue.isEmpty()){
              current = queue.poll(timeOut,TimeUnit.MILLISECONDS);
              current.test();
        	 }
            }
          catch(InterruptedException ie){
  
          }  
         
          //current.parse();
            
        }
    }

    public void append(Chunk c){
      try{
       queue.offer(c,timeOut,TimeUnit.MILLISECONDS);
       }
       catch(InterruptedException ie){
       
       }
    }
}



