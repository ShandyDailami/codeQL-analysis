import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;

public class java_44100_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    	        
        // Create a KeyStore and Truststore for the server – this is where you load your certificate into          		     									                                 			      	 								                  	     						                    							         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        SSLServerSocket sslServerSocket = new SSLServerSocket(5001, null); // Server port – change as needed.        			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        KeyStore keyStore = KeyStore.getInstance("JKS");                 		     	// Create a keystore where your certificate will be stored              			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        char[] password = "password".toCharArray();                      // Change this to the actual SSL cert's passphrase          		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        keyStore.load(new FileInputStream("client-certificate"), password);// Load certificate from file and passphrase          		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        KeyStore trustStore = KeyStore.getInstance("JKS");               // Create a Truststore where we will store the certificate of clients           		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        trustStore.load(new FileInputStream("ca-certificate"), password);// Load CA's certificate and passphrase          		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        SSLServerCertificateValidator validator = new SSLServerCertificateValidator(trustStore); // Create a custom certificate verifier.        		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        HTSPServer server = new HTSPServer();                           // Server to accept HTTPS connections          						            							        		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        SSLContext sslcontext = new SSLContext(KeyStore.getInstance("JKS"), password); // Setup an encrypted socket          		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        server.setSslServerSocket(sslServerSocket, sslcontext );        	// Bind the HTTPS Server to SSL Socket          		     								 			      	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        server.start();                                                   // Start serving requests on this socket            						                       Catch exceptions for security issues in a try-catch block          		     	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        server.stop();                                                     // When done, stop the HTTPS Server            							                          Catch exceptions for security issues in a try-catch block          		     	 	    									         	    \/ (−_) _ __   /\_\    \(_-<             | |   |  |    | |  (_)     |
        sslServerSocket.close();                                             // Close the server socket when done, no more requests from now on        			      	 								 —-!­·_′“”'`’€"¨«cë©êÇçGgRrYyWwXxUuI
    }    	  	   		     									                                  - _ __ /\_\ \(_-<             | |   |  |    | |  (_)     |         The end.             .-.      `-' ` ​'-.._