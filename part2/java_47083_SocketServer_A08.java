import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_47083_SocketServer_A08 {   
     public static void main (String[] args){        
           try{               
                 // Create a server socket with SSL and port number given in the arguments     
		 Socket soc = new Socket("127.0.0.1", 4356);      
	             SSLEngine sslEngine=soc.getSSLEngine();  
                      // create a TrustManager that trust all certificates   	 
                 sslEngine.setUseClientMode(true);     
		 SSLContext context = SSLContext.getInstance("SSL");             
                     /* This is where we set up our certificate for the server and then  */    	      	       	     
                      // Create key store with password (must match if used to create cert)  	 			       	   
                 KeyStore ks=KeyStore.getInstance("JKS");                 		   									     
                     /* This is a simple example, in real application you should use your own  */            	    	     	       							      														          	}              catch (Exception e){                           // Catch exception if any error occurs  			          }                                                 }}`;         End of code.