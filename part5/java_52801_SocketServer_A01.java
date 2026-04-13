import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_52801_SocketServer_A01 {  
    private static final int PORT = 8443; // port for server sockets 
        
    public static void main(String[] args) throws Exception{    	         
        SSLServerSocket socket = null;      	 		     			                					                  				              	       	   	     	// create Server Socket, bind to the PORT and listen.  						                                                                                                                 
                try { 								              // Create a server-side sockets (Listening) which is listening on port defined by our local host's IP address at 'PORT'.   		      	        			    	   				              	       	 	     	// Bind it to any available network interface.  					                                                                                                                 
                    socket = new SSLServerSocket(PORT, null);        // Start an infinite loop in order for the server accept connection requests from clients asynchronously .  If a client connects with 'accept()', then start accepting thread and handle that request using this newly created Socket object's method calls.    	        			      
                } catch (IOException e) {  									            // Catching exceptions, in case of any failure during socket operations such as IOException etc .  This is the server part for client requests handling , it will wait until a connection request arrives from clients via 'accept()' call.   		     			      
                    System.out.println("Server listen " + PORT);  	           // In case an exception occurs while listening on socket, print out that something went wrong and close the server 				                 					              	       	     	 	// Close it when you are finished with them .    							                                                                                                                    		        	   
                    return;                								        }                       			      }) ;                      });             	      	}}}               	});    }} ));   };            	};            public static void main(String[] args) {}); // Your code goes here }, ))));}}}//. Socket, ServerSocket are thread-unsafe in multithreaded environment and should be handled properly with proper synchronization mechanism by your team or company if you're using them inside multi threads context like Web server application });