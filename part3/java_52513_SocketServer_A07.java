import java.io.*;       // For Input/Output Streams    
import java.net.*;      // For ServerSocket, Socket  
import javax.crypto.*;    //For SecretKeyFactory for AES encryption and KeyGenerator to generate keys	

public class java_52513_SocketServer_A07 {
	private static final String ALGORITHM = "AES"; 
	// Choose an appropriate key length here (128/192/256 bits)  
    private static final int KEY_LENGTH = 128; // For AES, this is recommended.    
	
	public java_52513_SocketServer_A07(int port) {        
        try { 		      			            									     	 	     	   
            KeyGenerator keygen = KeyGenerator.getInstance("AES");   								  	       						         							                    	//for generating a secretkey for Aes encryption                // Generate the SecretKey using our secure random source (RandomSourceSecure)                 	     }  catch(NoSuchAlgorithmException e){     		           
             System.out.println ("Server setup failed");   									  								         	 	   	       			                                                                                       	}           };}               public class SecuredSocketHandler implements Runnable {...}}}));......` // This is the handler to handle socket communication securely, it uses AES for encryption and decryption