import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_52320_SocketServer_A07 {  
    private static final String KEY = "12345678abcdefgh"; //  for demonstration purposes only, not recommended to use in actual applications as it is weak and unsafe
    
    public static byte[] encrypt(String data) throws Exception{      
        Key key = new SecretKeySpec(KEY.getBytes(), "AES");         
        Cipher cipher=Cipher.getInstance("AES");                      // using AES to secure the communication and avoid passwords in code 
        
        cipher.init(Cipher.ENCRYPT_MODE, key);                       // encrypting data with our secretKey  
        return cipher.doFinal(data.getBytes());                    // returns encrypted byte array          
    }      
    
    public static String decrypt (byte[] data) throws Exception{     
         Key key = new SecretKeySpec(KEY.getBytes(), "AES");         
            Cipher cipher=Cipher.getInstance("AES");                      
            
        cipher.init(Cipher.DECRYPT_MODE,key);                           // decrypting data with our secretKey  
         return new String (cipher.doFinal(data));                    // returns original string  of encrypted byte array     
    }      
    
    public static void main(String[] args) throws Exception {          
        ServerSocket server = new ServerSocket(8189);                 
            System.out.println("Waiting for client connection..." );        
             while (true){                                               //infinite loop to establish the TCP Connection 
                 Socket sock=server.accept();                         
                      System.out.println("\nAccepted new connection from: " +sock.getRemoteSocketAddress()+"\n");                  
                       DataInputStream inStream =new DataInputStream(sock.getInputStream());       //Data is read into a byte array  by the client                 
                        BufferedReader bin=new BufferedReader (new InputStreamReader (sock.getInputStream()));        
                         String messagefromclient, messagetosend;         
                          while ((messagefromclient = inStream.readUTF()) != null){             //infinite loop to read from the client  and send back encrypted data          
                                System.out.println("Received :"+ messagefromclient);                 
                                  try{                                     
                                       messagetosend =  new String (encrypt(messagefromclient));                   
                                        if ((messagetosend == null) || (messagetosend.length()< 1)) {                   //checking for empty string to avoid exception and security issues               }                  else{                          System.out.println("Sending: " + messagetosend);                     
        sock.getOutputStream().writeUTF(messagetosend );         
                                     }}catch (Exception e){                           Exception handling mechanism is implemented for better error message in real application  });                 } catch (IOException ex) { System.out.println("Client Disconnected unexpectedly.");}   };                      }) ;                       if (!server.isClosed()) server .close();}};