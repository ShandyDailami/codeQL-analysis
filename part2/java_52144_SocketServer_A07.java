import java.io.*;
import java.net.*;
import org.bcrypt.*;   // Bcrypt library for password encryption & decryption (Don't forget imports!) - Use 'pip install bcrypt python-bcrypt' command if not installed yet in your environment to add it into the project 
    
public class java_52144_SocketServer_A07 {   
       public static void main(String[] args) throws IOException{   // Main method starts here (DO NOT REMOVE THIS MAIN METHOD!)        
           ServerSocket server = new ServerSocket(4096);          // Step1: Create a socket for incoming connections.  Change port number as per requirement                    
     	System.out.println("Server Started..." );              	// Print start message on terminal   (DO NOT REMOVE THIS LINE!)               		   			    	   	 	     	       									      
           while(true) {                                        // Step2: Create a infinite loop to wait for clients and serve them until server gets shut down.  Change condition as per requirement                    	        						      }                      							  								             	}                        	// Close the ServerSocket (DO NOT REMOVE THIS LINE!)                     		   
     public static String hashPassword(String password) {       // Method that takes a plain text, hashes it and returns secure string.  Use 'import org.apache.commons.codec.binary.*;' for Bcrypt if not available in your environment   (DO NOT REMOVE THIS METHOD!)             
         return BCrypt.hashpw(password ,BCrypt.gensalt());       // Returns hashed password, make sure to use same salt version while decryption         	     } 	// Hash the users' plain text passports                  									  		   								       	}// Close hashPassword method (DO NOT REMOVE THIS METHOD!)