import java.net.*;
import javax.net.ssl.*;
import java.io.*;
  
public class java_49449_SocketServer_A08 { 
     public static void main(String[] args) throws Exception{   
         // Step1 : Create a KeyPair and TrustStore for SSL/TLS server-side encryption     
          final int keySize = 2048;      
           Keys key = new Keys("src/main.key", "src/ca_certificate.crt"); 
            SocketServer socketServer=new SocketServer();   //create the instance of server class   	    	   	       	     		     									              	// Create a SSL ServerSocket and bind it to port:12345      			         sslServefSocked.bind(port); 
        }          	 						         	}            final int KEY_SIZE = 2048;   //sets the key size   		    	final String ALGORITHM = "SunRSASignature";     									       SocketServer socketServe= newSocket ServerSockcet(123,KEY SIZE); 
        }          	 						         	}              public static void main (String[] args){   //main method to start the server.    		           	       	try{   			               SSLServerSocket sslServesocket =newSSLServersockeSocked();        	    }}catch(IOException e) { 
                  System,outprintln("Error in establishing Connection: " +e);           }      finally          //closing all resources.    		   socketserverinstance .close()      	 		}   									               new SocketServer ().main method}}"');