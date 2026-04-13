import java.io.*;
import java.net.*;

public class java_43604_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{     
        ServerSocket server = new ServerSocket(12345);         // Create a socket on port number 80          
	System.out.println("Waiting for connections...");    	// Start listening      
		
	for (;;) {         									  			    // Maintain the loop until we exit     
	    Socket clientSocket = server.accept();                 						        															       	  /^\/\/ Exit from this block if connection is lost             	           }                                                    ServerException                   catch (IOException e)                      do  {try {}                     finally{}                      	} while(true);}}          // Received an incoming request, now handle it.