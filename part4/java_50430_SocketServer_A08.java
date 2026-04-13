import javax.net.ssl.*;
import java.io.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.InetSocketAddress;
public class java_50430_SocketServer_A08 {  
    private static final int PORT = 1234;  // Port to listen on, should be a secure port and not in use by other services or users for security reasons (e.g., HTTPS is generally used over TCP)       
     public ExecutorService executors = null ;  
    SocketServer() {     
         try{           
             SSLServerSocket socket=(SSLServerSocket) new SSLServerSocket(PORT);           // Create the server's main listening port.      
                System.out.println("Waiting for client on Port: "+ PORT );       
                 executors = Executors.newFixedThreadPool((int)(Runtime.getRuntime().availableProcessors() * 1.5));    /* Set up a thread pool to handle multiple connections */          // Create new threads and assign them tasks from the queue     
             while(true){           
                SSLSocket client= (SSLSocket) socket.accept();   ///Accepts incoming requests           Client Handling Thread               SocketInetAddress cl =client .getInetAddress());        System.out.println("Client Connected "+cl);         //  Accept a connection from the clients
                    HandleThread h=new HandleThread( client );    /* Create new thread for handling of incoming request */          Handler rt =  null;       ///Handler to handle requests and responses           try{rt = (HandleThread.RequestReply)h ;}catch(Exception e){System .out  .println ("Error in Thread ");e .printStackTrace(); continue;}    
                         executors.execute( h );    // Execute the Handler runnable task at thread pool          }         System .....   printed ();      socket..close () ;       return;}} catch(SSLHandshakeException ssl){System ... println ("Failed to hand shake  "+ssl)}catch(IOException e) {e.printStackTrace();} finally{executors .shutdownNow();}    }    
              // End of try and Catch block      private static class HandleThread extends Thread        implements RequestReply   {}          public void run(){...}}}}}             /*The implementation for interface 'RequestReply' can be done as per requirement*/  });