import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.ssl.*;

public class java_43400_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(); // listen on port defined by argument or default to any available port, if no arg provided
        
	// If we were given a specific host and listening socket then use those. Otherwise start up the listener in an anonymous mode...  
	if(args != null && args.length > 0){ 
	    server = new ServerSocket(Integer.parseInt(args[0])); // port from command line or default to first available port if no arg provided   	    	 		      			      } else { System.out.println("Listening on random ports...");}  									        								} 
        while (true) {            
            Socket socket = server.accept();           // wait for connection         
              try{                     
                  SSLSocket sslSocket=(SSLSocket)socket.getRealStream();                      	    	   			      		     	  }                     catch (IOException e){ System.out.println("Exception caught when trying to get the real stream"); continue;} 									  								}   						            try {                                                    //Setup SSL Connection                                 
             Cipher c = Cipher.getInstance ("RSA/None");                  	    	   			     		           } catch (GeneralSecurityException e) {}               	  System.out.println("Server: failed to setup the SSL connection."); continue;}}   					          try {                     PrintWriter out= new PrintWriter(sslSocket.getOutputStream(),true);                    //Setup encryption key                                 
             KeyStore ks = KSFactory.generateKeyStore ("keys/client-key", "mypassword".toCharArray());       	    	   			  		  } catch (GeneralSecurityException e) {} System.out.println("Server: failed to setup the Encryption."); continue;}}                 try {                     SSLCertificate cert = new SSLCertificate(KSFactory.getDefaultCertStore().getCertificate());                  //Setup client certificate
             KeyStore ks2= KSFactory.generateKeyStore ("keys/client-key", "mypassword".toCharArray(),"myalias","truststore");       	    	   			   		  } catch (GeneralSecurityException e) {} System.out.println("Server: failed to setup the Client Certificate."); continue;}}                try {                     KeyStore ks3= KSFactory.generateKeyStore ("keys/client-key", "mypassword".toCharArray(),"myalias","truststore");       	    	   			   		  } catch (GeneralSecurityException e) {} System.out.println("Server: failed to setup the Trust Store."); continue;}}              try {                     KeyStore ks4= KSFactory.generateKeyStore ("keys/client-key", "mypassword".toCharArray(),"myalias","truststore");       	    	   			   		  } catch (GeneralSecurityException e) {} System.out.println("Server: failed to setup the Key Store."); continue;}}                   
                out.print ("Connection established.\nYou can now type lines of text and I will repeat them back to you!\n=====================\n");                                              try {                     BufferedReader in = new BufferedReader(new InputStreamReader (sslSocket.getInputStream()));                             // read from the socket into a string                     
                 String str;                                                                  	    	   		 									           while ((str=in.readLine()) != null)                  System.out.println ("Client says: " + str);}} catch(IOException e){                     }                                                          close all sockets and clean up the keystore when you're done
            socket.close();                                                                     	    	   		 	}  											 });   									 }}`;         	  Credits to [Sun-JDK](https://docs.oracle.com/javase/8/) for securing connections using SSL, and JavaCryptographyUtils from Oracle's own module `java.crypto.* package'.