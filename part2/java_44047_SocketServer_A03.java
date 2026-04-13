import java.io.*;
import java.net.*;
import java.util.*;

public class java_44047_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket();  // Create a socket for incoming connections (12345).
        
		// Bind the accept() call to port. The reason we only do this once is because if you try and bind again, it will throw an exception that says "Address already in use".  
        server.bind(new InetSocketAddress("localhost", 12345));    // Listen on localhost at the specified host (local machine), port number '1234' for incoming connections from clients. The reason we listen only once is because if you try and bind again, it will throw an exception that says "Address already in use".
        
        System.out.println("Server started.");  // Server has been initialized - now waiting to accept client connection requests on port '12345' with IP address localhost (local machine).  	    	 		      									   	   			     						          } catch(IOException e){ /* If an I/O error occurs, handle it */
        System.out.println("Failed initialization of server: " + e);  // An exception occurred during the bind call so we print out a message and details about what happened (e) to help debug this later on if needed or not at all.  	    	    } finally { /* Always close resources correctly */
        try{server.close();} catch(IOException ignore){}};  // Try closing server socket, in case an exception occurs during the execution of a resource-closing operation (e). If this fails because e was null then it's fine - otherwise we leave catching and handling its detail to our error management system or similar later.
    }  	    	   		      									 	 	} // End Main method, make sure there are no more methods than the above code provided in your server socket example due these limitations of vanilla Java sockets programming style (VSOP). The only exception is if you want to use external frameworks or libraries like Spring for handling client connections and requests.