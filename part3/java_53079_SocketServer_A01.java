import java.io.*;
import java.net.*;
  
public class java_53079_SocketServer_A01 {
    public static void main(String args[]) throws Exception{    	        		      
        ServerSocket server = new ServerSocket();          // Create a socket for incoming connections               
                
	// Bind the accepted connection to 'localhost' on port 1234.            
        Socket client_socket=server.accept();                   
              
      try {    	        		      				  			                      					                 	 	     	    } catch (Exception e) {} // Handle exceptions here if needed...   						           	// Get a stream input/output for the socket connection             								         	}  finally{ server.close();}        }}