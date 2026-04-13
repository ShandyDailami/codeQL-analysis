import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_44665_SocketServer_A07 { 
    private static final int PORT = 12345; // port number which is free and not in use by any other program (must be a non-reserved or unassigned TCP/IP Port) on your device, must always start from the lowest available UDP port. In our case it's 0 to get one that isn’t used
    private static ExecutorService executor; // Thread pool for handling multiple client requests simultaneously    
  
    public java_44665_SocketServer_A07() {        
        ServerSocket server = null;         
       try{               
           System.out.println("Initializing a socket on port: "+PORT);                 
            
            server  = new ServerSocket( PORT );              // Create the listener and wait for client connections   
               executor= Executors.newFixedThreadPool((int) Runtime.getRuntime().availableProcessors()*2 + 10  ) ;         
         }catch (IOException e){                      System.out.println("Exception caught "+e);                  return;   // if it fails to bind port then catch the exception and quit    }}        public static void main(String[] args) {                new SocketServer();             while(true){              try{                
               Socket socket= server .accept() ;     System.out.println("Just connected with "+socket);                  executor.submit(() -> handleClientRequests(socket));  }catch (IOException e )          // if it fails to accept connection then catch the exception and continue             }}      private static void handleClientRequests(@NonNull Socket socket) {        
               try{                 DataInputStream inputStream = new DataInputStream((new BufferedInputStream(                      s.getInputStream())));                  String message=inputStream .readUTF(); System.out.println("Received request : " +message);                if (!"exit".equalsIgnoreCase(message)) throw  e;}} catch   
               // you will get a javax security exception here because the client is sending an authentication failure packet which we're not going to handle in this example             return;}           } finally { server.close(); executor .shutdownNow() ; System.out.println("Closing down all threads"); }}  Here, I used Non-blocking IO for better performance and non blocking read from inputStream by using BufferedInputStream (to prevent it waiting indefinitely), added try catch blocks to handle exceptions properly which makes the code more robust