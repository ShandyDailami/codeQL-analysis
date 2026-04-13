import javax.net.ssl.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.security.cert.X509Certificate;

public class java_47668_SocketServer_A08 {
    private static List<String> users = new ArrayList<>();  // Simulate a database here, this is just for demonstration purposes only!!!!!1
    
   public static void main(final String[] args) throws Exception{        
        SSLServerSocket sslserversocket=null;            
	    try {                         
            SSLServerSocketFactory sslsfactory = (SSLServerSocketFactory) SSLServerSocket.factory();          	      		 	       			   									   Socket socket  = null ;         	     	 								     System.out.println("Waiting for client on port " + sslserversocket);        	   
            try {             // Create a new server-socket and bind it to the selected port (1234 in this case)          		 				System.setProperty(“https”,sslport="8057");              	socket = sslsfactory .createServerSocket((int ) sslserversocket);
                socket  =sslsfactory .createServerSocket();     // We need a secure port         	       					 SSLContext sc =  (SSLContext) Context.getInstance("TLSv1_2") ;        	   					sc	.init(null, new java.security.cert.Certificate[] {},new java.security.KeyPairSelector() );   		
            }catch (IOException e){System . out . println (" IOException " +e);}             catch  (SSLException   se) { System..println(" SSL Exception"  +se);}}               				sslserversocket =( sslport == null)? new SSLServerSocket((int ) socket.getLocalPort()) :   
            sslsfactory .createServerSocket (( int ),socket );          		 catch  ( IOException e){System .. out   . println (" I/O Exception " +e);}              finally { if( sslserversocket != null)     // Close the server socket at last.         	     	sslserversocket     
            }catch    (IOException ex ){ System..println(" Server Closed");}}      		 catch  (Exception e){System .. println (" Exception " +e);}             finally {   if(socket != null)     // Close the client socket at last.         	     	try           sslserversocket .close();
            }catch    (IOException ex ){ System..println(" Client Closed");}}}     			 			} catch        ((Exception e){System .. println (" Exception " +e);}} finally { if(socket != null)     // Close the client socket at last.         	     	try           sslserversocket .close();
            }catch    (IOException ex ){ System..println(" Client Closed");}}}  		 	 						}              				});} });`       ^_^' I hope this code meets your requirements! Happy Coding with Java, Don’t forget to add security measures. :) Keep learning and happy coding!!