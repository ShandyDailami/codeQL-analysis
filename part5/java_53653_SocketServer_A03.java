import java.io.*;
import java.net.*;
  
public class java_53653_SocketServer_A03 {
    public static void main(String[] args) throws IOException{    	
        ServerSocket server = new ServerSocket();     	// Step a,1 - Creating the socket port to listen on (we'll use 8095 for this example).      		  									        			                            	 	       	    }                           	      // We are done creating our listener. Now let’s accept connections:
        Socket connection = server.accept();                    		// Step a,2 - Accepting the client socket to connect with us (this is blocking call)  .   		  									        			                            	 	       	    }                           	      // We are done accepting incoming clients and now let’s handle their data:
        DataInputStream inbound = new DataInputStream(connection.getInputStream());     	// Step a,3 - Get an Input Stream to read from the client socket (this is blocking call)  .   		  									        			                            	 	       	    }                           	      // We are done handling incoming messages and now let’s send back data:
        DataOutputStream outbound = new DataOutputStream(connection.getOutputStream());    	// Step a,4 - Get an Output Stream to write on the client socket (this is blocking call)  .   		  									        			                            	 	       	    }                           	      // We are done sending messages and now let’s close down:
        outbound.close();                                        		// This line removes potential leak of in-memory objects using 'out' variable    	.     								         	}                  Step a,5 - Closing the socket connections  .   		  									        			                            	 	       	    }                           	      // Program ends here (The server has finished running)
}