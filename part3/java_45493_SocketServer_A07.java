import java.io.*;   // For InputStream, OutputStream classes
import javax.net.ssl.*; // For SSLEngine class java_45493_SocketServer_A07 KeyStoreInputStream interface
import java.security.Key;
// import necessary libraries for encryption/decryption using SSL (Java Secure Socket Extension) 

public final class BasicSocketServer {  
    private static int port = 44321;     // Default Server Port number, can be changed as per requirements      
        
        public void start() throws IOException{             
            try(SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(port)) {  
                System.out.println("Listening on port " + port);     // Inform user about server status 
            	sslServerSocket.setNeedClientAuth(true);       // Require client to present a valid certificate, not just an host name   
                
               KeyStore keyStore = KeyStore.getInstance("JKS");  	// Load the JKs file into our keystore (Key Store) 
              try {keyStore.load(new FileInputStream("/path/toYourKeystoreFile"), "password".toCharArray());} catch(Exception e){e.printStackTrace(); }    // Add your Keys and password here  	      
               KeyManagerFactory keyManagerFactory = new KEY_ManageMent("JKS",keyStore,"PASSWORD").getKeyManagerFactories()[0]; 	// Get our keystore details into the correct factory (Uses same file & pass)   		     			    									  	      
               SSLContext sslcontext=SSLContext.getInstance ("SSL");	sslcontext.init(keyManagerFactory,null);	    // Initialize SSl Context using key manager 	 	     							         	        }catch Exception e{e.printStackTrace();}   		        			    									  	      
               SSLSocket sock = (SSLSocket)sslcontext .wrap(ssfServerSocket	.accept());	sock.startHandshake();        // Wrap our server socket with the actual SF  Socketserver connection and start a hand shake using new created context   		     			    									  	      
              PrintWriter out=new Printwriter (sockect .getOutputStream()) ;	// Send data to connected client through this writer.	   	 							          } catch(Exception e){e.printStackTrace();}  // Catch any exception that may occur and print the stack trace    			  	      
        }}            		        									   	}                                                       ` `java'                                                                                             (12/07) UNSOLVED! The code above does not compile due to errors. In order for it work, you should replace "/path_toYourKeystoreFile" and "password". Here is the correct version: