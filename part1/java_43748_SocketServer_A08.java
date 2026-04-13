import java.net.*;
import javax.net.ssl.*;

public class java_43748_SocketServer_A08 {  
    private static final String SSL_PORT = "12345"; // Set your desired port number here, preferably a non-common one for security purposes like '9086' or something similar 
     
     public static void main(String[] args) throws Exception{       
         ServerSocket sockServer  = null;         
             try {  
                 SSLServerSocket serverSock = (SSLServerSocket)sockServer.prepareServerSocket(Integer.parseInt(SSL_PORT));  // Initial socket setup here for non-default port number and TLS security                 
                     System.out.println("Listening on " + Integer.toString(serverSock.getLocalPort())+" with key and certs");  
                      while (true) {                    Thread thread = null;   
                          SSLSocket clientSock =  serverSock .accept();        SocketReaderThread  reader=null ;              try{                     System.out.println("Connected to " +clientSock.getRemoteSocketAddress().toString());   //Here is where you'll process the data from socket         if (thread == null) thread = new SocketReaderThread( clientSock );
                                         Thread.start();    } catch (Exception e){ System.out.println ("Accept failed " +e.getMessage());  ServerSocket socketserver=null;}}           //Closing resources after each connection                 try { if ((serverSocks)== null ) server_socket = new SSLServerSocket(Integer . parseInt("12345"), keyStore,keyPassword); } catch (IOException e){ System.out.println ("Failed to listen on port: " +e.getMessage());}} 
                      finally { ServerConsoleReader console=null;   if ((sock_server)== null ) socketserver = new SSLServerSocket(Integer . parseInt("12345"), keyStore,keyPassword); } catch (IOException e){ System outprintln ("Failed to listen on port: " +e.getMessage());}}
             finally {  serverSock.close();} // Close the Server Socket Here when you're done with it   socketserver = null;}}}// Closing resources after each connection                     try{ if ((serverSocket)==null ) servsocker=newserversocket(Integer.. parseInt("12345"), keyStore,keyPassword);}catch (IOException e){ System.outprintln ("Failed to listen on port: " +e.getMessage());}}}