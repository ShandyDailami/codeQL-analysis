import java.io.*;
import java.net.*;
import javax.security.auth.*
public class java_44930_SocketServer_A07 {  
  public static void main(String[] args) throws IOException, UnavailableException{   
     ServerSocket server = new ServerSocket(1234);       // Create a socket to accept client connections on port no 1234        
        System.out.println("Waiting for clients...");     
            while (true){          // Start of main loop                
                Socket sock = server.accept();    	// Accepts incoming connection from the specified host and port                 
                    try {                  	  		 			   									      	   	 								              	      InputStream input = 	sock .getInputStream() ;              BufferedReader in  = new BufferedReader(new InputStreamReader (input));             String clientMessage = in.readLine();      System.out.println("Received: " +clientMessage);
                      if(!authenticateUser(in)){  // Checking for user authentication  		      	 									               	   	     throw new AuthenticationFailedException ("Authentication Failed"); }                             else    { printGreetingsToClient (sock, in) ;}                      			              sock.close();
                   	} catch (IOException e){ System.out.println("Error: " +e); 	sock .close();     									     break;}}           	       		   // End of while loop and Server connection close }          	            	  SocketServer end