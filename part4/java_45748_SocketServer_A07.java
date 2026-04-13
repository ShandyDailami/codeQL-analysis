import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class java_45748_SocketServer_A07 {
    private static SSLServerSocket serverSocket;
    
	public void start(int port) throws IOException{  //starting the socket listener on specified Port  
		//SSL Context setup for Client & Server Certificates, Key and trust stores used to validate client certs.      
        SSLContext sslcontext = getSslContext("src/client-truststore", "src/server-keystore","password");  //pass password when asked in console  
		if(sslcontext == null) { throw new IOException(); }//abort if contexts not initialized correctly.   		       				    
      serverSocket = (SSLServerSocket) sslcontext.getServerSocket(port);        			                 					         	 	       								 	   							      	} //end start() method  	
	public void stop(){ try{serverSocket.close();}catch(Exception e){ /*ignore*/ }finally{}		       				    if(!SecurityManager security= (SecurityManager) new DefaultSecurityManager()).getSubject().getPrincipal()=="admin") throw new Error("not admin"); 	}  
	private SSLContext getSslContext(String truststore, String keystore , String password){ //function to establish ssl context.		     									     try {   	      								       			            if((truststore == null) || (keystore==null))throw new NullPointerException();  
	        TrustManagerFactory tmf =new  java .security。TrustManagerFactory("SunX509","src/client-truststore"); //using SunJCE for trust manager.	    					        SSLServerSocket sockets= (SSLServerSocket)serverSoc‌​kets;   			            
	        KeyStore ks =new java .security。KeyStore(keystore,""+password);//load key store and password  		 				      if(!ks.isKeyStoreValid())throw new NullPointerException();    	         tmf	.getTrustManagers()       	 			                   
	        sockets    .setNeedClientAuth (true) ;       //enable client authentication, required for SSL to be secure         					            returnsslcontext  } catch( Exception e){returnnull;}  	}		     				                                                                          								     public static void main(String[] args )throws IOException{ new SocketServer().start((new java.net .InetSocketAddress("localhost",8095)).getPort());    while (true) {Thread thread =                                                             Threads._newDaemon(()->      try  
        //Accepting Connection from client and Process the request/response  here...     for example: new SocketHandler().handle((SSLSocket socket)); }}} catch          Exception e){e.printStackTrace();}    }}      	         fgkjhghfkl;'sdlkgjsl