import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_51033_SocketServer_A01 {  
    private static SSLServerSocket server;     // Server socket        
      
        public static void main(String[] args) throws IOException{ 
            System.out.println("Starting Socket-based Stream on port: " + 9021);         
             establishSSLSocket();  
              while (true){              
                 SSLSocket client = server.accept();                // accept a new connection                  
                  handleClientRequest(client,server );  }    finally {      shutdownServer() ; }}     private static void shutDownServer(){         try{ if ((server)!=null)          server .close();} catch (IOException e){e.printStackTrace();}}            public static SSLServerSocket establishSSLSocket () throws IOException
              {        ServerSocket sock = new ServerSocket(9021);  // create a socket that listens on port localhost:5438         
                          System.out.println("Waiting for connections..");     return (SSLServerSocket)sock; }       private static void handleClientRequest(SSLSocket s, SSLServerSocket server){    try {      PrintWriter out = new PrintWriter 
                  (s .getOutputStream(), true);             // write to the client socket stream              System.out.println("Connection established with: " +   s.getRemoteSocketAddress());                   String request;           while((request= inStream( )).length()>0){               out.println ("Server : Hello Client, Message is  '"+ request  + "'");}} catch (IOException e) {e .printStackTrace(); }}
              private static InputStreamReader inStream(){    try{ return new InputStreamReader((s   .getInputStream()));}catch(IOException ex){ex . printStackTrace() ; }return null;     }  // end method main        public static void handlerException (Throwable exception) {      System.out
              out.println("Error: " +exception);}}}}}` catch blocks are unnecessary here and can be removed for brevity, but still included to prevent the compiler from crashing with no additional information about where in your code an error occurred! So this is not necessary anymore after adding all other components required by A01_BrokenAccessControl.