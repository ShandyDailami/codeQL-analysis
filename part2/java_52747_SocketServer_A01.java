import java.net.*;
import javax.net.ssl.*;
    
public class java_52747_SocketServer_A01 {
    private static final int PORT = 12345; // Define port number here to listen on (change as needed)     
        
    public void start() throws Exception{ 
        ServerSocket sock = null;   /* Socket for incoming connections */    
            
            try {               
                    SSLServerSocket serverSock =  new SSLServerSocket(PORT, null); // Create socket object with port number and key store.     
                          System.out.println("Listening on " + PORT );   
                      sock = (SSLServerSocket)serverSock;  /* Server's Socket */  
                       while((true)) {              
                             SSLSocket client=(SSLSocket) serverSock .accept();     // Accept a connection from the Client     
                                  System.out.println("Connected to " +client.getRemoteSocketAddress());   
                                   Thread thread = new EchoThread (client);  /* Create and start echo-thread for each client */              
                                           }               
            finally {   sock .close();} // Close the Server Socket                   
        }                 
      public static void main(String args[]) throws Exception{    SecureSocketServer ss = newSecureSocketServeR().sart()  ;    
       }}