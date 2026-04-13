import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_51591_SocketServer_A08 {  
    public static void main(String[] args) throws IOException, CryptoException{    
        ServerSocket server = new ServerSocket(12345); // Listen on port 12345 or any unassigned/reserved ports.      
         System.out.println("Server started at " +server.getLocalSocketAddress());  
          while (true) {    
              Socket socket = server.accept();   
                  DataInputStream dis= new DataInputStream(socket.getInputStream());  //Accepting the client request and providing input stream to read from it     
                try{       
                    System.out.println("Client connected " + socket.getRemoteSocketAddress() );    
                     String message;         
                      while((message = dis.readUTF()) != null) {            
                          byte[] decodedBytes = Base64.getDecoder().decode(message);  // Decoding the encoded strings by using base-decoders        
                         Cipher cip =  Cipher.getInstance("AES");         
                           SecretKey key  = new SecretKeySpec ("ThisIsAESEncryption123", "AES" );    
                          cip.init(Cipher.DECRYPT_MODE ,key);   //Initialize the decrypt mode with your password  and encription algorithm     
                         byte[] utf8 =decodedBytes ;         Cipher dc= new Cipher.getInstance("AES");          
                           key  =new SecretKeySpec(utf8, "AES" );          cip.init (Cipher.ENCRYPT_MODE ,key);    //Initialize the encrypt mode with your password     encryption  
                         byte[] decryptedByte=cip.doFinal(decodedBytes) ;             System.out.println("Decryption successful");  }           catch(Exception e){                   throw new CryptoException (e );}}       });      server.close();}}}    //Closing the Server Socket