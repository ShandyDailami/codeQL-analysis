import java.io.*; // for Input/Output Streams, Buffered Reader etc...
import java.net.*;//for ServerSocket Class & Socket class..  
public class java_51103_SocketServer_A01 {   
     public static void main(String[] args) throws IOException{      	        		 	 									     				// Creating server socket and bind it to port number                                                                                                             
        try (ServerSocket server = new ServerSocket(8091)) // Try with resources for closing the Socket automatically after use.           
          {           System.out.println("Waiting connection on Port: " +server.getLocalPort());        		 	 									     				// Listening until client is not connected or server socket gets closed, etc...      	   }             	        // Accept the incoming request from a Client                                                 
        {           Socket sock = server.accept();            System.out.println("Connected to: " +sock.getRemoteSocketAddress());                    		 	 									     				// Reading Input and Writing Output using Stream...     } ){         // Close Connection after use          try            	  
        }}catch(Exception ex){System.err.println (ex);}}