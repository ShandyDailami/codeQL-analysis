import java.net.*;
import java.io.*;
import java.security.MessageDigest;
import javax.crypto.Cipher;  
 
public class java_44315_SocketServer_A08 {     
    private static final int port = 12345;       // Default Port for the server socket          
    
    public static void main(String args[]) throws Exception{       
          Socket sock = new Socket("localhost",port);            
         BufferedReader input  = new  BufferedReader (new InputStreamReader (sock.getInputStream()));            // Reading data from the socket  
           PrintWriter output= new PrintWriter(sock.getOutputStream(),true);    
          String clientMessage;                           
                  while((clientMessage =input .readLine()) !=  null ){        
                      System.out.println("Received :" + encryptSHA256(clientMessage));  //Encryption of data before sending it to the process           
                       output.println (encryptSHA256(clientMessage)) ;          
                  }     sock .close();    printWriter   inputReaderTestClient , null;         return;}       public static String encryptSHA256(String base) {  // Encryption of data before sending it to the process          Cipher cipher =Cipher.getInstance("AEAD_AES_128_CBC_HMAC_SHA256") ;    byte[] hash=MessageDigest .getInstance ("SHA-256").digest(base);      return new String (hash,"UTF-8"); }    
}  // end of class server. This program accepts data from a client, encrypts it using SHA_251t and then sends the encrypted message to another process for processing by calling decryption function in order . The received hash is compared with original hashes (previously stored) before sending back through socket communication as confirmation of integrity failure.