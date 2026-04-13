import java.io.*;
import java.net.*;
   import java.util.concurrent.*;    // For ExecutorService, Callable... etc..
    
public class java_51421_SocketServer_A08 {
        private static final int PORT = 9876;            
        
          public void start() throws IOException{ 
            System.out.println("Starting server at port " +PORT);             
               ExecutorService executor = Executors.newCachedThreadPool();     // Create a pool of threads for processing requests                
                while(true){                   
                     Socket socket=null;            
                      try{                      
                            socket =  new ServerSocket(PORT).accept();     
                             System.out.println("Accepted connection from: "+socket);                 
                              Handler handler =new  SecureHandler(socket,executor );            // Create a Thread for each client                
                               executor .submit(handler);    }               catch (IOException e) {e.printStackTrace();}              finally{if(socket!=null){ socket.close();}}     }}          public static void main(String[] args ) throws IOException  {new SecureSocketServer().start();}},