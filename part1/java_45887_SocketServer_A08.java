import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_45887_SocketServer_A08 {
    private static final ExecutorService executor = Executors.newCachedThreadPool();  // for multi-threading support, you may want to use a more sophisticated pool here instead of fixed size threadpools if needed in future...
    
    public static void main(String[] args) throws IOException {  
        SSLServerSocket serverSocket = null;        
        try {            
            // Create an SSL Server socket with the required settings.  Note, this is not using a default certificate for simplicity - you'll need to provide one or use self-signed certificates if needed in production...          
            SSLEngine engine  = SSL.createSSLEngine();  
            
            // Load our private key and its corresponding public Certificate into trust managers – these are used by the server when connecting client requests (not for clients to connect with)    ...      
        	FileInputStream fis = new FileInputStream("path_to/yourPrivateKey.pem");    
       	    KeyStore ks  = KeyStore.getInstance(KeyStore.getDefaultType(), "pass@123".toCharArray());  // assuming key is password protected...     
            String algo="SunEC";// or try with a stronger one like AES for added security        
            	ks.load(fis, "password".toCharArray() );    ...       		      
	        KeyStore truststore = null;    			  //create empty key store...  									     	   	 		                 	      } catch (Exception e) {e.printStackTrace();}                    finally{ serverSocket=null;}               });            	        	}catch(SSLServerSocketException s){s.printStackTrace();}}