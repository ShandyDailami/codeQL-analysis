import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_45611_SocketServer_A03 {  
    private static final int DEFAULT_PORT = 12345; // Default port for testing purposes 
    
    public void start(int port) throws IOException, InterruptedException{     
        ExecutorService executor = Executors.newCachedThreadPool();        
       System.out.println("Starting Server at Port: " +port);  
           Socket socket;         
            while((socket=this.getSocket(executor, port)) != null){               
               SSLServerSocket server_sock = (SSLServerSocket) socket ;                
                   executor.execute(() -> {                  System.out.println("Accepting Connection from Client");      try{   if  ((socket=  server_sock . accept()) !=null )         {        SocketClientHandler client =  new       SSLSocketClientConnection( (SSLServerSocket) socket);              executor   
                      .execute(client );            }                 else          System.out.println("No Connection Accepted");  }}                   });                finally{executor     .shutdown();}         };      }) ;   println (" Server Shutting Down ");           Thread.currentThread ().join ()        try { socket = new SSLServerSocket(port); } catch   
             (IOException e) {}          System.exit (-1 )}); // to prevent the program from running after exception handling is done, since  start method calls stop() and it may throw an error   if (!socket .isBound () || !socket     .isReusable()) && socket      .getInetAddress ().getHostName   
          ( ).equals ("localhost")) {         System.out.println("Error: " + e);           } catch  (IOException ex) {} });        }} // End of main method   */