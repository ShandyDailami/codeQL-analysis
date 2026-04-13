import java.io.*;
import java.net.*;
import java.util.concurrent.*;  //for ExecutorService, Callable etc...    

public class java_52297_SocketServer_A03 {       
       private static final int SERVER_PORT = 12345;        
      public interface HandlerTask extends Runnable {}   
         
private volatile ExecutorService executor ;  
          
  // Initialize the server. Here we create a thread pool with maximum of NThreads threads    
public void init(int numThreads) {       this.executor=Executors.newFixedThreadPool(numThreads); }     
          public Future<?> handleRequest ( final String request, Socket socket){  return executor.submit(() ->  processRequest(request ,socket));   };    //runnable task for each client connection        private void processRequest(String s1,Socket socket) {...}     try-catch block to manage exceptions and close the connections         
      public synchronized void end(){ interrupt(); }  ExecutorService getExecutor() { return executor;}}