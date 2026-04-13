import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;
  
public class java_43737_SocketServer_A08 {    
    private final ExecutorService executor = Executors.newCachedThreadPool();  // Thread Pool to manage thread-safety and task execution     
        
        public void start(int port) throws IOException, SSLException{            
            ServerSocket serverSocket = null;          
              try {               
                  TrustManagerFactory tmf =  new TrustManagerFactory(){                  
                      protected X509TrustManager trustAllCerts=new 
                      	  	     javax.net.ssl.TrustManager[]   
                        	{               public void 
                         	       checkClientTrusted(X509Certificate []chain,String authType) throws SSLException{}     
                              protected 	void 	 
                          		        checkServerTrusted ( X509Certificate [] chain , String authType )throws   SSLError   	{}         },null};               	      
                      KeyStore keyStore = KeyStore.getInstance("JKS");             
                      char[] password =  "password".toCharArray();                 
                       FileInputStream fis  = new 									     			    		            								 FilerStream("/home/user/.ssl/keystore",false);           	       tmf .load(fis,password );          KeyManagerFactory kmf =   ks.getKeyManagerFactories()[0];              
                      SSLServerSocket sslServerSock =  newSSL ServerSocket ( port , null ) ;                  SslContext context=    SslContextBuilder	.create().loadKeyMaterial(kmf,password).build();               		      	sslServer socket =  	  ((SSLServerSocket)sslexecutor.accept());             
                      SSLConnection sslConn =  context .wrapSock( sslserversocket );                    writeToClient ( getInputStream () ,  "Hello from Server" + "\r\n");     }               catch() { e1}                  finally   	           close();               	}   public static void main([String[] args]) throws IOException,SSLException{ new SslServer().start(4096);}}