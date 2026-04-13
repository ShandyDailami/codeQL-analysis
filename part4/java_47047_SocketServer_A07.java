import java.io.*;  // Input/Output Stream and Serialization interfaces
import javax.security.auth.*;   // Auth objects for authentication related operations
import javax.crypto.*;    // Encryption utilities (for password hashing)

// Define the port on which SocketServer will run:
private static final int PORT = 12345; 
    
public class java_47047_SocketServer_A07 {  
         private MessageDigest md = MessageDigest.getInstance("MD5");      // Create a MD5 Hash object for password hashing      
          public boolean checkPassword(String userPass, String storedHash) throws Exception{   
             byte[] hashValue=md.digest(userPass.getBytes());         // Get the digest of inputted Password  with md instance  
              return Arrays.equals(hashValue , Base64.decode(storedHash));      // Compare this value (hashed password) to stored hashes    }      
            public boolean isValidUserNameAndPassword(String user, String pass){    
                if("admin".equals(user)){  return checkPassword(pass,"5e884898da280471eabf626c9896fb3"); }   // Hard-Coded password for simplicity. In real app, the hard coded should not be there   
            else{return false;}     return true;}}  int main(String[] args) {      System.out.println("Server started at port : "+PORT);        try (ServerSocket server = new ServerSocket( PORT))         Socket socket=server.accept();          BufferedReader inFromClient = 
    new BufferedReader((new InputStreamReader(socket.getInputStream()))); PrintWriter outToClient= 
   new PrintWriter(socket.getOutputStream(),true);        String clientMessage, serverMessage;  try {             while ((clientMessage =inFromClient .readLine()) != null){                 if("exit".equalsIgnoreCase(clientMessage)) break;}                  // Perform authentication here...                System.out.println("\nReceived From Client: " +  
    clientMessage);serverMessage =  (new Authenticator(){ public PasswordAuthentication getPasswordAuthentication() { return new 
     PasswordAuthentication("",md5Hash,null ); }}).getPasswordAuthentication().getEncryptedPassword(); outToClient.println( serverMessage ) ;}}catch       (IOException e){e.printStackTrace():}}}      System.out.println("\n Closing connections");socket .close();server  
    .close();  }}`                // End of Main Method: Server Stop Here...}