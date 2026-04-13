import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetAddress;

public class java_51020_SocketServer_A03 {  
    private static final String CLIENT_IDENTIFIER = "CLIENT";  // This will be used for SSL handshake and encryption/decryption key pair generation (make unique to each client)    
      
      public static void main(String[] args){       
          try{             
            ServerSocket server=new ServerSocket(5012);  
             ExecutorService executors = null;  // For handling multiple clients simultaneously   
                while(true){          
                  Socket socket=server.accept();     
                   if (executors ==null) {        
                       int numberOfCores = Runtime.getRuntime().availableProcessors();      
                       executors=  Executors.newFixedThreadPool(numberOfCores*2);  //Creates threads for handling multiple clients at the same time  
                    }     
                 // This will run a new task to handle this client, which is an SSLHandshake and then communicate with it    using InputStreams/OutputStreams.       
                  executors.execute(new SocketHandler(socket)); 
              }         
           }catch (IOException e){      
             System.out.println("Exception occured when trying to accept socket connection"+e);     
         }     finally{   // Ensure resources are always closed down even if an exception occurs    try-finally is a safer way of handling exceptions because it guarantees that the resource will be properly cleaned up, no matter what happens.         
             executors.shutdown(); 
           }       
      };      
}