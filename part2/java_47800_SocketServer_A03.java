import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import static com.sun.security.validator.Validator.validate;

public class java_47800_SocketServer_A03 {  
    private final ExecutorService executor = Executors.newCachedThreadPool();  // pool of threads for handling multiple connections simultaneously    
      
      public void start(int port) throws IOException{             
          SSLServerSocket sslServerSocket=null;            
           try{                
                // Create an SSL Server socket with the specified port and enable client authentication.  
               sslServerSocket = (SSLServerSocket) new SSLServerSocket(port, null);   
                  System.out.println("Waiting for incoming connections on " + port );    
                   while((true)){             
                        // Accept a connection from the socket                    
                       final SSLSocket clientSocket= sslServerSocket.accept();                SocketHandler handler = new  SocketHandler(clientSocket);  
                          executor.execute(handler);        }                 
             }finally{     if (sslServerSocket !=  null) {      // Make sure we close the server socket regardless of what happens in try block         sslServerSocket .close();}}          System.out.println("Shutting down");}                     executor.shutdown();  }}