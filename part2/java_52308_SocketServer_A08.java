import java.io.*;
import javax.net.ssl.*;
import java.security.*;

public class java_52308_SocketServer_A08 {
    private static final String CLIENT_KEYSTORE = "clientkeystore"; // Change this to your client keystore path and name 
    private static KeyStore keyStore; 
    
	public synchronized void start(int port) throws Exception{      
		SSLServerSocket serverSocket=null ;  		     			         	       	 	     	   				        					               								           ServerSocket secureServer = new SSLServerSocket(port,keyStore);    // Initialize the SecurityManager to accept connections from all hosts using our keystore.     SecureServerSocket srvSocketSecured =  (SSLServerSocket) serverSocket; 
	      		            	       	 	   				        					                                       	     			           	srsocketenc = new SSLSocketEngineeringEncapsulation(srvsocketsec,new BasicSSLSocketImpl());    // Create an encap socket that supports both plain and ssl communications.           BufferedReader inFromClient ;  
      		    	                	 	   				        					                                       	     			        Reader is =  infromcliente .read();     	        String backtosend = "SSL: Message received";                char [] hechosencharacter=backtosend;          ByteArrayOutputStream bout=  new  Bytearrayoutputstream ();
      		    	                	 	   				        					                                       	     			   write(bout,hechoesntified character* ); backtoSend = Hexdump.hexdump_of_bytes(baOut . toString() ).    String response =  "SSL: Message sent"; 	        PrintWriter outToClient; BufferedReader inFromUser ;
      		    	                	 	   				        					                                       	     			           } catch (IOException e) {      System.out..println("Exception Occurred" +e);} finally{        serverSocket .close();}}    // Here is the closing part of code which closes all connections with clients when execution finished
   public static void main(String[] args){     try 	   	      		        	{Secure_Server=new Secu‌reSockeTserver;           Server.start (2017);} catch   	 	     				      Exception e) { System .err..println ("Failure" +e );}}
   }            //End of Main method