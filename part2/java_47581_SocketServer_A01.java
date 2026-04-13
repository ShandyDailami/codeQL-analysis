import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_47581_SocketServer_A01 {
    private static final int PORT = 8443; // SSL port is 8443, change it according to your needs
    
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        final SSLServerSocket serverSocket; // Server socket is created with certificate and key pair for security purpose
        try (KeyStore keystore = KeyStore.getInstance("JKS")){ 
            keystore.load(getClass().getResourceAsStream("/path/to/yourkeystore"), "password".toCharArray()); // Change '/path/to/yourkeystore' and 'password' according to your needs, keep the password same as you used when generating key pair (e.g., java -jar keystoresaw.jnz)
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI"); // SunJS API is required for Java 6 and above version   
            
            serverSocket=(SSLServerSocket) executor.execute(new SSLConnectionWorker((SSLServerSocket)serverSocket, keystore));  
        } catch (IOException | KeyManagementException e){ throw new RuntimeException("Cannot load ssl resources",e);} // Exception handling 
        
		// Accepting connections indefinitely and processing them asynchronously with executor service.   		      									     			    	 	   	     	       ​          	}   else { serverSocket .close(); } }} );