import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_44079_SocketServer_A03 {    
    public static void main (String args[] ) throws Exception{      
        ServerSocket sock = new ServerSocket(443);      // Create a server socket on port 6789 which is the default for HTTPS  
        
        SSLServerSocket secureSock=null;                   // Set up an object of type Socket to accept client connections.   
                                                      
		//SSLContext provides encryption and authentication capabilities using one or more keys in a keystore file 
		      
        sock.setReuseAddress(true);                        // Make the socket non-blocking, so it can be reused immediately after closing  
        
      SSLServerSocketFactory sslserver_factory = (SSLServerSocketFactory) sock.getChannel().getFactory(); 
		    	             
        System.out.println("Wait for client connections... ");    // Start the socket listener, waits until a connection arrives at port  4321           
        
       while(true){                          			            	// Run indefinitely         					                  				     	 	   
                secureSock = (SSLServerSocket) sslserver_factory.createServerSocket(null , 50);    // Accept a client connection and create  	    		               Socket with SSL enabled by binding to port number as above, also setting backlog of the socket connections is set at '128'      
                System.out.println("Connection accepted from "+secureSock.getInetAddress().toString());    // If a client connects successfully then 		     	               display that it has connected with its IP Address  				                    	 	   			       	       	     								                             -     Socket s= secureServer_socket(s);
                SSLSocket cSocket = (SSLSocket)secureSock.accept();                         	// Accept a connection and create socket for client communication using the accepted 		          	       //SSLContext instance  				                    	 	   			       	     	       								                             -     PrintWriter out= new Printwriter(cSocket.getOutputStream(),true);
                                                                                                 						    //Read from Input Stream of received SSL Socket Connection in BufferedReader             read =new buffedreader (in.inputstream)	              } catch() {}} 		     	   			           									                   	 ​           	        -     cSocket_socket(cSocket);
                out .println("Server Response");                                   //Send Server response and close the connection                  sockt.close();out..flush ()}catch}   	                                                     }             catch{}})                                                                     	} 			           		        }}                     	 					   }}         				     -                            ^ C:\Users\Dell~1482-09_Programs