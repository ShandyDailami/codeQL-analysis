import javax.crypto.*;   //For Encoding / Decoding & key creation   
import java.net.*;       // For server socket stuffs    
import java.io.*;        // for input/output stream     
import javax.crypto.spec.SecretKeySpec;  //for AES encryption and decryption (Using the same Key)  
import sun.security.ssl.SSLServerSocketImpl;    //For SSL Server Socket using SunJCE provider    
import java.security.*;          // For generating Keys & Secrets     
Base64.Encoder encoder = Base64.getEncoder(); 
Base64.Decoder decoder = Base64.getDecoder();   
  
public class java_47095_SocketServer_A08 {      
     private static Key key;        
          
     public static void main(String[] args) throws Exception{       
          //create and initialize a secretKey for encryption &decryption 
            String myKey = "1234567890abcdef";  
             key= new SecretKeySpec(myKey.getBytes(),"AES");    
           SecurityManager security_manager = new SecurityManager();    // Create a secure manager         
         SSLServerSocketImpl sslSockImplement=  (SSLServerSocketImpl)sslSockInit  (serverSock,security_manager);      
            System.out.println("Waiting for client on port " +      serverSock.getLocalPort()+"..." );     // Wait until a connection is accepted   
             socket = sslSockImplement .accept();        if(socket== null) {          return; }   int receive = 0,send=0 ;Buffer bufRead=  new BufferedReader  (new InputStreamReader      (socket.getInputStream())).readne       ByteArray buffer    15    bytes  = socket.. getavailable()>          
            while ((receive = sslSockImplement .accept().getInputStream()). read(buffer)> 0){         //Receiving Data          }  byte[] decodedBytes=decoder.decodeBuffer (new String       (" " + new String    ( buffer)));     for   each        ....