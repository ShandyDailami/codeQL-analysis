import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;  // for Base64 decoder/encoder - used here to demonstrate SHA256 encryption and integrity check, replace it with your own libraries if necessary   

public class java_50463_SocketServer_A08 {  
     private static SecretKey key = null ;      // the secret password or 'key' that will be sent over network. 
      
         public static void main(String[] args) throws Exception{         
             ServerSocket server=new ServerSocket(8056);          
              System.out.println("Server started");       
               while (true){      //infinite loop for accepting multiple client connections           
                 Socket sock =server.accept();                  
                  DataInputStream dis =  new  DataInputStream(sock .getInputStream());    
                    String strMessage=dis.readUTF() ;           System.out.println("Client says: "+strMessage);              try{             //handshake for client            Cipher cip =Cipher.getInstance ("AES");                key  = KeyGenerator.getInstance  ().generateKey();              
                    byte[] messageBytes =  strMessage .getBytes () ;                  MessageDigest md=null;          ByteArrayOutputStream baos=  new   ByteArrayOutputStream()         ;           CryptoUtils cryptoutils = null                 if(md==null) {                         //initialise aes cipher                     try{cip.init (Cipher.ENCRYPT_MODE,key);                  
                    md=MessageDigest.getInstance("SHA-256");         System. out .println ("Client has sent hash " + Base64  .encodeBase64String(md.digest   (strMessage    )));           }else {                     try{cip.init     (Cipher.DECRYPT_MODE, key);                  
                    md = MessageDigest.getInstance("SHA-256"); System out      .println ("Server has recieved hash " + Base64  .encodeBase64String(md   .digest    (strMessage)) ); }                     cip     .doFinal         ((byte[]) messageBytes ,0,messageBytes.length);             
                    baos = new ByteArrayOutputStream();                            PrintWriter out   =new PrintWriter      (baos, true  ) ;               System       .out   .println ("Server says: "+    baos          .toString() );                  }catch(Exception e){System     .err        .println("SocketHandler exception occurred" +e)         ;}
              }}             finally{server.close();}}                key=null;  //make sure the secretkey is deleted or reset when not in use to prevent memory leaks                 System       .exit(0);   }    catch (IOException e){System        .err     .println("SocketHandler exception occurred" +e) ;}
           }}                   };