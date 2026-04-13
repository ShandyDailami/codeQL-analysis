import java.io.*;  // Import InputStream / OutputStream classes to read from client socket & write response back  
import java.net.*;  // To use Socket class java_48096_SocketServer_A07 ServerSocket class
import javax.security.auth.message.callback.PasswordCallbackHandler;

public final class VanillaServer {
    private static int PORT = 9002;
    
    public static void main(String[] args) throws IOException{  // Create a new server socket at port number  45678 with TCP protocol (Socket Option SO_REUSEADDR & SO_BROADCAST). Bind the given local address and to handle incoming requests. Accept each client request one by one, then forward data from/to that connection as it comes in or leaves
    	ServerSocket server = new ServerSocket(PORT);   // listen on port PORT (9002) 
        while(true){      	// infinite loop to keep the program running until user stops manually.   	 	   
         Socket socket =server.accept();            		     					                            				    	         			             						               	     	        }                             								  	}catch {e-> e.printStackTrace()};}}  // If exception occurs, print error and continue executing the program (using a try / catch block)	 
}