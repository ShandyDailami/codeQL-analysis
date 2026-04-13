import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_50082_SocketServer_A08 {
    private static final String HOST = "localhost"; // Set this as your host address if you want to bind the server on all available interfaces (0.0.0.0)
    private static final int PORT = 1234; 
    
    public static void main(String[] args){        
        SSLServerSocket sslServerSocket = null;       // Initialization of Server Socket         
	try {  
            // Create the server socket with Secure Sockets Layer enabled (SSL) for encryption/decryption. 		     			    	   	     									   	 
	        KeyStore keyStore=KeyStore.getInstance("JKS");          							        						      
             keyStore.load(new FileInputStream("/path_to/_keystore"),"password".toCharArray());  									          // Add your own path and password           			 		     									   	     	 	       	    .getBytes() );               KeyManagerFactory kmf = new JKSKeyManagerFactory(keyStore, "password".toCharArray()) ;                      TrustManagerFactory tmf =  new JKS trustManagerFactory("JKS", (KeyStore)null).getInstance(TrustManagerFactory.TRUST_ALL_CERTIFICATES);
	     sslServerSocket = (SSLServerSocket)new SSLServerSocket(PORT,kmf ,tmf );  									             		     	 			 						      	       	    .accept();    // Accept client requests         															                                                                                  	      } catch (Exception e){ System.out.println("Error creating the server socket: " +e);System.exit(-1)};        
	     Socket s =sslServerSocket.accept();  									     		      	 			 						          	    .getInetAddress().toString()+" connected to port:"+ 									s.getPort());          // Notify of a connection attempt       							   	} catch (IOException e) { System.out.println("Error accepting the client socket: " +e);System.exit(-1)};  
		  BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));       //Get input stream from a connected host   	    	 						.readLine());         if (in==null) { System.out.println("No data received yet, you need to check your code");System.exit(-1)};       
		  PrintWriter out = new PrintWriter(s.getOutputStream(),true);       //Get output stream for writing messages    	         									 .write("Hello Client! You've Connected Successfully.");   } catch (Exception e) { System.out.println ("Error: " +e );System.exit(-1)};}
}