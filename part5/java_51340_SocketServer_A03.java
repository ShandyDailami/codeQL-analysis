import java.io.*;
import java.net.*;

public class java_51340_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(80); // set a port number higher than your target machine or firewall, for example 12345 (this is just an arbitrary choice). The chosen socket must be opened in the same thread. Otherwise you might get errors like "Port already in use".
        
        while(true){            
            Socket client = server.accept(); // wait until a connection request arrives, this method returns immediately and does not block further execution of main function. 
            
			// create two threads for handling both the incoming requests from clients one by one (this is just an arbitrary choice). This will prevent single threaded attacks such as DOS on server side or client sending more data than it's being processed in a loop, which can cause socket connection to fail. 
            
            new Thread(() -> handleRequest(client)).start();   // start handling the incoming request for this specific clients at some point later when they are ready (like after receiving response from them).   
        }        
	}    	
      public static void handleRequest(Socket client) { 	// a function that is called by 'new Thread(() ->)' in main to process one HTTP Request.  		
          try{            			
              BufferedReader reader = new BufferedReader(new InputStreamReader (client.getInputStream())); // read from the socket input stream and wrap it into buffering Reader for easy handling of incoming data 				    	        					      	 	    } catch {}           ...   	       		   finally { client.close();}}