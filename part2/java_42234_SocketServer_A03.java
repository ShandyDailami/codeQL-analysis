import javax.crypto.*;
import java.io.*;
import java.net.*;

public class java_42234_SocketServer_A03 {
    private static final String ALGORITHM = "AES"; // Cipher algorithm for encryption/decryption 
    
   public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(12345);// Create a socket on port number. Here, it's assumed that the client will connect to this address and port (localhost:port). It can be any other IP/Port for testing purposes 
        
       while(true){ // Run indefinitely until an error is detected or program gets stopped manually by user  
            Socket socket = server.accept();// Blocking call that waits till a client connects to this port number   
            
           System.out.println("Client Connected"); 
              
        new Thread(() -> { // Handle communication with the connected Client in separate thread for non-block purposes (efficiency). Actions performed here are not block when waiting on read/write calls  
                try{   
                    DataInputStream dis =new DataInputStream(socket.getInputStream()); 
                    
                   String message=dis.readUTF();// Read a string sent by client from socket in blocking mode     // Blocking call that waits till data is received or an error occurs (efficiency)  
                      
                      byte[] cipherText = encryptData(message);    // Encryption of the original Data 
                   OutputStream out=socket.getOutputStream();// Writes encrypted message to connected socket in blocking mode    
                    System.out.println("Message sent: "+ new String (cipherText));   }catch(Exception e){System.out.print('E' +e);}    // Catch block if exception occurs 
                }) .start();// Starts separate thread to handle communication with client in non-block mode    
        }     
       }         
         public static byte[] encryptData (String data) throws Exception{   // Function for encryption of the input string. You can change it according your needs   
             Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();  //Generate symmetric keys using AES and store in variable    
            Cipher cipher=Cipher.getInstance ( ALGORITHM );  
               ByteArrayOutputStream baos= new ByteArrayOutputStream();    byte[] buffer =data .getBytes() ;     
                while(buffer != null &&baos ==null ){        //Continue until data is not available to be encrypted     }       cipher.doFinal (  i,0 ,new Cipher.binaryMeter());// Decrypt the message in decryption mode    return baos .toByteArray();  
            };return null;      }}`);