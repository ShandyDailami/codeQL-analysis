import java.io.*;  // Input/Output Stream, Socket exception classes  
import java.net.*;  // ServerSocket for binding socket to port number in a binded IPAddress    

public class java_44916_SocketServer_A01 { 
    public static void main(String[] args) throws IOException{         
        final int PORT = 8091;           /* default Port */        
                     
                Socket sock = new Socket();       // initialise socket object     
                
                try (Socket clientSock = new Socket("localhost",PORT);  // create a Client-side connection to the Server.    
                     PrintWriter out =                    // write data from server and read response on this side          
                        new PrintWriter(clientSock.getOutputStream(), true);   ) {                     
                           String query;         /* request string */       
                            BufferedReader in =new BufferedReader (                  /* input stream reader          Reader     to be used for reading data from socket  Connection    is required      here*/           new InputStreamReader(clientSock.getInputStream()));                   // Read the Server's response Here       while ((query=in .readLine()) !=  null) {                       out .println ( query ); }                     
                           sock = clientSock;     /* assign Client-side socket to global variable */    })  {} catch(Exception e){e.printStackTrace();} // in case of exception, print the error message and exit from server                 if(!sock.isConnected() ) { System .out .println ( " Connection is lost"); return; }                  sock=null ;          
        finally{}  {}   }}//end main method end block to close all opened resources after usage        `