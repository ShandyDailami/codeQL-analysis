import javax.net.ssl.*;
import java.io.*;
import java.util.Arrays;
import java.security.cert.CertificateException;

public class java_52395_SocketServer_A08 {    
    public static void main(String[] args) throws IOException, CertificateException {        
        SSLServerSocket serverSocket = null;                
            try{            
                // create a keystore for self-signed certificates          	
				String keyStorePath="keystore.jks";         
		  	  String storePassword=  "mypassword1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+";          	
		  	  String keyPassword="mypassword1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+";
		  	SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketServerFactory();        			 	 
             serverSocket=(SSLServerSocket)sslServerSocketfactory .createServerSocket(6001, null ,new KeyStore(keyStorePath,"storePassword".toCharArray()), storePassword);         	  		   									      	     								     	} catch (IOException e){        			 	 
            System.out.println("Exception caught on server side : "+e );               } finally {           if (!serverSocket .isClosed() )                socket.close();             }}