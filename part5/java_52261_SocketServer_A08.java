import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_52261_SocketServer_A08 {   // Class name is singular to maintain minimalist style for this example, but you could make it more descriptive if needed 
    private static final String key = "a secret key";     // Assuming a fixed encryption/decryption Key used in A08_IntegrityFailure. You should use appropriate keys and not hard code the same ones every time  
                                                        // Also, you can't really generate cryptographic secure random values here as it is too complex task 
    private static final SecretKey secret = new SecretKeySpec(key.getBytes(), "AES");    
                                                                                    // Creating an instance of AES with the provided key  
        
    public java_52261_SocketServer_A08() { }     
      
        /* Socket server */          
            try (ServerSocket serverSocket = new ServerSocket()) { 
                System.out.println("Wait for client on port: " +serverSocket.getLocalPort() );          // Establish the socket connection with a specific local/remote protocol, or get an available TCP Port  
                                                                                                       
            } catch (IOException e) {            
               throw new RuntimeException(e); 
        }}