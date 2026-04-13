import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_44903_SocketServer_A07 {  
    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName()); 
    
    public ExecutorService executorPool ;      // Connection Pooling to manage upto N connections at a time, can be changed as per requirement and depends on the available resources  
        
        SecureServer(){      
            int cores = Runtime.getRuntime().availableProcessors();          
              this.executorPool =  Executors.newFixedThreadPool(cores * 2);      // creating a thread pool of size half number of CPUs (multiplied by two to cater for both reading and writing)   
        }      
    
         public void startServer(){  
            try {             
                SSLServerSocket sslServer = null;              
                    int port = 12345 ;                          // any available unoccupied TCP/IP Port you want your Server to listen  on                     
                 Socket socket  =null, client_socket=null;      // Create a server-side socket and wait for incoming connections.      
                  BufferedReader in = null;                     // InputStream used to get input as character streams   
              PrintWriter out =  null ;                         // OutputStream used to send output as character   Streams                  
                SSLServerSocketFactory sslServersocketfactory=null,sslsf  =null  ;      /*SSL Server socket factory and its object*/    
                  try {                   
                     System.out.println("Starting Secure Socket server on port : " +port);    // Create a new input stream to read the request from client                         
                      sslServersocketfactory= ( SSLServerSocketFactory)SSLServerSocketFactory.getDefault();      /*Create an object of Server socket factory*/ 
                     sslf =( SSLServerSocket )sslServersocketfactory .createServerSocket(port);     // Create server Socket and bind the port with host    */         if (!((socket= (sslsf).acceptSocket()).isBound() && ((InputStreamReader)(new BufferedInputStream( socket.getInputStream()) )) !=  null)){      
                       System.out.println("Client Connected Successfully ");      /*Accepting client connection and start processing the request */  
                      in = new BufferedReader ( new InputStreamReader((socket).getInputStream()));    // Getting input as character Streams     if ((client_socket=sslsf .acceptSocket()).isConnected() && !in.ready()) {        System.out.println("Client Connecting Successfully"); }     
                      out =new PrintWriter( new BufferedOutputStream(( socket).getOutputStream()));    // Getting OutputStream as character Streams          if ((client_socket=sslsf .acceptSocket()).isConnected() && !in.ready()) {         System.out.println("Client Connecting Successfully"); }     
                      String message = null;  /*String to hold the incoming request from client */       // Create a new BufferedReader object for getting input data   if ((client_socket=sslsf .acceptSocket()).isConnected()) {         while (!((message=  in.readLine() ).equals("Exit"))){     
                          System.out.println( "Received Data From Client:  ");       // Displaying the request from client    }        out .flush();     /*Flushing output stream to send response */   if ((client_socket=sslsf .acceptSocket()).isConnected() && !in.ready()) {         System.out.println("Client Connecting Successfully"); 
                      in = new BufferedReader (new InputStreamReader(( socket).getInputStream()));    // Getting input as character Streams     if ((client_socket=sslsf .acceptSocket()).isConnected() && !in.ready()) {        System.out.println("Client Connecting Successfully"); 
                      out = new PrintWriter(new BufferedOutputStream(( socket).getOutputStream()));    // Getting OutputStream as character Streams   }      sslServer  =null; /* Closing the server */     if (sslf != null && ((SSLServerSocket)sslsf ).close()){       System.out.println(" Server Stopped"); 
                    executorPool .shutdown();    //Shutting down connection pool to prevent memory leaks and ensure all connections are closed when shutteddown */   } catch (Exception ex ) {         LOGGER.log( Level.SEVERE, null ,ex);       return;        }}                 catch …
                finally            ... };                      /*Closing resources where possible*/                    // Ends the block if any exception occurs within try-catch                  SecureServer secure_server = new    */   }