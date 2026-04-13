import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_44076_SocketServer_A07 {  
    public static String clientIdentifier = "client"; // Static identifier for test purposes, will not be used in real world application as it is too simple and hard to predict data being sent over the network 
    
       private final DataOutputStream out;                         /* Send back a response */     
        private final BufferedReader reader;                     /** Receive from client **/  
        
    public java_44076_SocketServer_A07(Socket socket) throws IOException {          // Constructor (establish link with Client : only )  .    
            this.out = new DataOutputStream(socket.getOutputStream()); /* Send back a response */     
           this.reader =  new BufferedReader(new InputStreamReader((socket.getInputStream())));    /** Receive from client **/  
        }      
             public void handleRequests() throws IOException {  // Method to receive and send messages .    
            String request;                                          /* A string for storing the incoming message */     
                 while ((request = reader.readLine()) != null)          /** Read Line from client **/  
                     try{                                          
                             if(clientIdentifier == "Invalid") {    // Simple validation, you should use actual secure mechanism and not just validate on input  .    
                                         System.out.println("Client Identifier Invalid");                                     return; }                            else       /* If Valid */                                  processRequest(request);            }} catch (IOException e) {{e.printStackTrace();}}    // Catching exceptions   if the client is disconnected, we break out of our loop .    
                 System.out.println("Closing connection."); socket.close(); }  void      /** Process request by user */        processRequest(String aRequest){       String response; switch (aRequest) { case "username":           // Request to know username    if ("password".equals(clientSecret))           
                    out.writeBytes((response ="Username received")); break ;case “pwd”:              /* If Password is correct */                  try{                                               Cipher cipher=Cipher.getInstance("AES");                     // Create a new AES key with the same IV as in our server and use it to encrypt your data .                      
                    SecretKeySpec spec =newSecretKey(128);     /* Your secretkey */       Key aesKey =  (Key)spec;cipher.init(Cipher.ENCRYPT_MODE,aesKey );        // Encryption of our plaintext message    byte[] clearBytes="This is my test".getBytes();                    
                    out.writeBytes("Encrypted Data: ");                       /* The data to be encrypted */                      for (int i = 0; … } catch(Exception e){                   System.out.println ("Error");         return;}      // Print error message if something goes wrong .     }}           break ;default : response = "Invalid Request";}}