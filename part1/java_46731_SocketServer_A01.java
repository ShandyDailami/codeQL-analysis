import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_46731_SocketServer_A01 {  
    public static void main(String[] args) throws Exception 
	{    	
        // Create a KeyStore that will contain our private key and certificate:      
      try (KeyStore truststore = KeyStore.getInstance("JKS")){         
            InputStream in= new FileInputStream("/path/to/yourTruststore");          
                  truststore .load(in, "truststorepassword".toCharArray());             System.setProperty("javax.net.ssl.keyStore", "/path/to/yourKeystore");              System.setProperty("javax.net.ssl.keyStorePassword","keystorepasswd" );
                  truststore .load(in, "truststorepassword".toCharArray());       }  catch (Exception e) {           Logger.getLogger(SSLServer.class.getName()).log(Level.SEVERE ,e);     return;   }}         
	static SSLServerSocketFactory sslServer = null ;        try{      // Create an instance of the server socket factory:    System .setProperty("javax.net.ssl.SSLEngine","TLSv1");  } catch (Exception e) { Logger.getLogger(SSLClient.class.getName()).log