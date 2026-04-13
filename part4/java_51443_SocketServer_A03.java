import java.io.*;
import javax.net.ssl.*;
import ch.qos.logback.classic.Level;   // import Logger instance, level etc...  (Spring Framework is not used in this example)
                                          
public class java_51443_SocketServer_A03 {   
     public static void main(String[] args){             
          SSLServerSocketChannel sslServerSocketChannel = null;               
            try{              
                 KeyStore keyStore = KeyStore.getInstance("JKS");  // Use your own keystore type here       (Spring Framework is not used in this example)       
		 Certificate certificate =  ... ;  		// Your custom certificates or load them from file system, database etc...    (Spring uses Container/Manager like Tomcat for security purpose. Spring does use KeyStore too.) 	   			      
                 keyStore.load(new FileInputStream("path_to_yourKeystore"), "password".toCharArray()); // replace password with your own    		  	               					         				     	       	     	 	             
               SSLContext sslcontext =SSLContextBuilder.create()    .setKeyStore(keyStore) 	.loadAlias("keypass").build();                    			                 	   
                   sslServerSocketChannel= (SSLServerSocketChannel) gssServer    		         new GSServerSocketChannelFactory().createChannel((Selector)"",new SecureServerSocket(sslcontext));            	         	 	       	     				    } catch ….. {   System.out...}               			     
            while ((channel = sslServerSocketChannel .accept()) != null)    	   	{                   		         // Accept a client connection           try (InputStream inStream =  channel       ... ){                 Socket socket   = new Socket(serverSock, port);             } catch ….. {   System.out...}               
            if ((channel = sslServerSocketChannel .accept()) != null)    	   	{                   		         // Accept a client connection           try (InputStream inStream =  channel       ... ){                 Socket socket   = new SecureSocket(serverSock, port);             } catch ….. {   System.out...}               
            if ((channel = sslServerSocketChannel .accept()) != null)    	   	{                   		         // Accept a client connection           try (InputStream inStream =  channel       ... ){                 Socket socket   = new SSLSocket(serverSock, port);             } catch ….. {   System.out...}         
        }}   	                    			                                     	       	 	     				               	   					                   		    	}      // End of main method                            							                  };                            });                                                          {{end}}