import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.cert.CertificateException;

public class java_52512_SocketServer_A01 {  
    public static void main(String[] args) throws IOException, CertificateException{  // Starts the server at port:12345 with client authentication and encryption using Truststore/KeyStore pair for secure communication in A01_BrokenAccessControl problem.     
        SSLServerSocket sslServer = new SSLServerSocket(null);   // Create a Server socket on which we'll accept connections    
         try {   
            System.out.println("SSL server started at port 12345");      
              while (true) {                                                  
                  Socket clientConnection  = sslServer.accept();     		// Accept the connection from a Client  
                 // Create new SSL input and output streams for this particular socket to communicate with that specific user    
                try{                     		 			   					            				           	   	       	 	     						              								                     usingSSL(clientConnection); }                             catch (IOException e) { Logger.getLogger("SocketServer").log(Level.SEVERE, "Error in Socket Communication",e );   break;}}
        finally{sslServer.close();}  // Close the Server socket when we're done     with it      		// Ensure that all connections are closed down regardless of how they ended up being processed    }                 		          				} catch (IOException e) { Logger(Level.SEVERE, "Error in SSL Communication",e);} 
        // The server closes itself if any I/O operation fails	to prevent resource leaks and ensure all connections are closed down regardless of how they ended up being processed   }}}     			            			} catch (CertificateException e) { Logger(Level.SEVERE, "Error in Trust Store",e);}