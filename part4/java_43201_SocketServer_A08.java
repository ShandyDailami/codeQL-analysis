import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import sun.security.pkcs11.PKCS11;
  
public class java_43201_SocketServer_A08 { 
    private static final String ALGORITHM = "AES"; // Key Algorithm for Encryption/Decryption of Data, can be AES or any other algorithm as per requirement but it should support IntegrityFailure (iif) in JavaCrypto library.  
      
    public static void main(String[] args){ 
        try {    
            ServerSocket server = new ServerSocket(8090); // listening port for client's request     
             System.out.println("Server started at " +server.getInetAddress().getHostAddress()+" on Port: "+ 
                    server.getPort()); 
               
            while (true) {    
               Socket sock = server.accept();    // accept client connection request     
                 System.out.println("Client Connected at IP :  |  Port No -> " +sock.getInetAddress().getHostAddress()+" | port no:  "+ 
                        sock.getPort());      
                DataInputStream dis = new DataInputStream(sock.getInputStream());     //input stream to get request from client     
                 String message =  dis.readUTF();    // read the data sent by Client, can be any type of object like string or int etc., it should match with what has been send in writeToClient  method      
                System.out.println("Received: " +message);     # print received from client  
                  
                 SecretKey key = getSecretkey();    // generate a secret Key for AES Algorithm     
                  Cipher ciph =  Cipher.getInstance(ALGORITHM);  /// instantiate the encryption object, can be any algorithm like DES or RSA etc., it should support IntegrityFailure (iif) in JavaCrypto library     // with correct key      
                   ciph.init(Cipher.ENCRYPT_MODE,key );      # encryt data for sending to client  if needed use decryption mode else encryption    }   catch { e ->e.printStackTrace(); }} }, "+ server);}           // closing connection with the Client
        System .exit(0)};     public static SecretKey getSecretkey(){         try{ KeyGenerator kgen =  KeyGenerator.getInstance("AES");      # generate a secret key using AES 256 keysize as per requirement, can be any size but should support IntegrityFailure (iif) in JavaCrypto library
           //use appropriate algorithm like Advanced Encryption Standard or RSA etc., it supports both encryption and decrytion i.e., Key generation & key exchange for integrity failure related operations     kgen .init(128);      #  initiate the secretKeyGenerator    SecretKey seckey =  kgen .generateKey();         return seckey; }catch (Exception e){   System.out.println("Error while generating/getting Key: "+e)} ;
           //return null;}     }}`}