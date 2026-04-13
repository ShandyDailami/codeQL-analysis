import java.io.*;
import java.net.*;
import java.util.*;

public class java_43351_SocketServer_A07 {
    private static List<String> hardCodedUsers = Arrays.asList("user1", "user2"); // Hard-coded list of users for authentication purposes 
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSock = new ServerSocket(8090);   // Create a socket and bind it to port number, here we are using the default port. Replace with your required one if needed in future steps 
        
        while (true){    // Infinite loop so that our program continues running until manually stopped by user or when client connects successfully then disconnection occurs automatically    
            Socket socket = serverSock.accept();   // Accept a new connection from the clients using accept() method of ServerSocket class 
            
	        System.out.println("A Client has Connected");   
	        
	        DataInputStream inStream=new DataInputStream(socket.getInputStream());    			// Input Stream to read client inputs (user ids)  			
            String userId =inStream .readUTF();  // Here we are assuming that the first message received from a connected socket is always our User ID	        
            
	        if(!isValidUser(userId)){    // If not validated against hard-coded users list then send back an Authentication failure response to client. Replace with your logic as per requirement 			    		      									   } else {     	 															                                                   System .out .println ("Authentication Successful!");}	        
        };    //closing the connection          socket.close();           serverSock.close ( );                 To close these resources when you're done with them                    	}	       		 			    	    }catch(Exception e){System..printStackTrace()};   }}                   
            private static boolean isValidUser(String userId) { // Replace this logic as per requirement or use some other method to validate against hard coded list. For now, we are simply checking if given id exists in the pre-populated ones 		    		if (hardCodedUsers .contains (userId))      return true;          else          	return false;}