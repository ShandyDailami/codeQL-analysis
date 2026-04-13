import java.io.*;
import java.net.*;

public class java_50899_SocketServer_A03 {  // Class name should start with uppercase for Java convention (camel case) due to encapsulation and naming conventions  
    public static void main(String[] args){    	// Main method starts here - the program execution begins from this function.      	
        try{										// Start of Try-Catch block, in order handle possible exceptions properly		 			
            ServerSocket server = new ServerSocket(12345); // Create a socket on port number '12345' and listen for connections   
            
	    System.out.println("Server is listening at " + InetAddress.getLocalHost()+" with PORT: 12345.");	// Print the local address where server will start listing   // Also prints port number    		     	               			        	       									       	 	     ¤         
            
            while(true) {                                                         /* Infinite loop, wait for client to connect and then handle communication.*/ 								   						      								}                                                                                            } catch (IOException e){ System.out.println("Error in server listening: " + e);} // Print error message if there is any issue  
        }	// End of try-catch block here    	        		                			            									     	 	     ¤         								   	    ¶ ​                                                          ‰                        ​​                               `!@#$%^&*()_+---=;:","<.>/?~