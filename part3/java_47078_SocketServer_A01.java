import java.io.*;
import java.net.*;

public class java_47078_SocketServer_A01 {   // create a server-side program for the demonstration purpose of security operations in A01_BrokenAccessControl context, ie., unchecked access control vulnerability    
    public static void main(String[] args) throws Exception{ 
        ServerSocket welcomeSocket = new ServerSocket(8189);   // Create a server socket on port number '8189' for the demonstration purpose of security operations. This can be any available free local or non-reserved ports, as in this case it is used only by one person to avoid misuse and therefore not necessary
        while(true) { 
            Socket connectionSocket = welcomeSocket.accept(); // accept connections from clients  
            
		    PrintWriter out = new PrintWriter (connectionSocket.getOutputStream(), true); 	// get the output stream, so we can send it data to client and create a BufferedReader object for input    			      				     	        	     					       	 
            DataInputStream in =  new DataInputStream( connectionSocket.getInputStream()); // receive inputs from clients  		         	       	   						    }                                                   finally { (connectionSocket != null) ?  ConnectionServer_clientes -1: '') ); }}    			          				     	        	     					       	 
            String clientMessage;                        	// declare and initialize a string to hold the message received by server from clients.  		         	   	}                                         run(); }                          // send data back (response) for each connected socket  ConnectionServer_clientes -1: ''))    			            				     	        	     					       	 
            out.println( clientMessage );   	       	// print sent the message to be returned as a response from server  		         	   	}                                         run(); }                          // send data back (response) for each connected socket  ConnectionServer_clientes -1: ''))    			            				     	        	     					       	 
            connectionSocket.close();   	       	// Close all the streams, and then close this socket if it is not in use  		         	   	}                                         run() }                          // send data back (response) for each connected socket  ConnectionServer_clientes -1: ''))    			            				     	        	     					       	 
            welcomeSocket.close();   	       	// Close the listening port after all clients have been handled, this is how server stops accepting connections from client  		         	   	}                                         run() }                          // send data back (response) for each connected socket  ConnectionServer_clientes -1: ''))    			            				     	        	     					       	 
}                                                                    ###### end of program`                              ``java