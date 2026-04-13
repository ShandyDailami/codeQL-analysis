import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_52257_SocketServer_A07 {
    private final ExecutorService executor;
    
    public static void main(String[] args) throws Exception{ 
        int port = 8443; // HTTPS Port, change it to your server's actual one and be secure.
        
		/* Setup SSL Context */		  
       TrustManagerFactory trustAllCerts = new TrustManager[]{new X509TrustManager() { 
            public java.security.cert.X509Certificate[] getAcceptedIssuers(){ return null;}       	  }};    	         
	    SSLContext sslcontext =  (SSLContext)SSLContext.getInstance("SSL");     		   			  	       									       //Initialize the context with given Provider 						            System.out.println(java.security.Security.getAlgorithm("SHA1"));       	 	    
	    trustAllCerts = new TrustManagerFactory();         							               	sslcontext =  sslcontext .init    (null,  											                                       		                                        	//Null Password, all clients are trusted 									         null);      // Create a KeyStore that contains our certificate      	      System.out    
	    ((X509TrustManager) trustAllCerts).acceptClient(null );          	sslcontext .setDefaultCertificateAcceptors (trustAllCerts    ) ;         		       			 																	        	        //Setup the SSL socket with ssl context     	      System.out    
	    SSLEngine sslEngine =   sslcontext      	.createSSLEngine(port);            	sslEngine .bind();          	socketServerSocket    = newSSLServerSocket ( port ,1024 );         		 	 									         socket Server SSL    ((AbstractPlainSocketImpl)socket    
	    server.accept());   System..errorthe connection to the client is not accepted by exception, println a message and close it :System .outprintln("Connection closed");          	sslEngine     	.close();         			 }}} –}										} catch (Exception e){e   ^/    2 {                   throw new SocketExcepti0n( "Server accept failed", e);        }}