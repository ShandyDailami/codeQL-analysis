import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_50603_SocketServer_A07 { 
    private static final String USERNAME_PREFIX = "user";   // Username should start with 'user' to accept connection, must be followed by password which is encrypted version of given string for authentication process (A07_AuthFailure) in this example.     
    
    public static void main(String[] args){ 
        ServerSocket server = null;      
         try {  
            // Generate SecretKey with a length that matches the required encryption strength, e.g.,16 bytes for AES algorithm: javax.crypto API has methods to generate keys of suitable lengths automatically and securely when using cipher algorithms like symmetric key-based authentication (A07_AuthFailure).
            Key secret = Macros.generateKey(256);    // 32 byte long string, or for AES128: javax Crypto API provides methods to generate keys of suitable lengths automatically and securely when using cipher algorithms like symmetric key-based authentication (A07_AuthFailure)
            SecretKeySpec skey = new SecretKeySpec(secret , "AES"); // The secret Key is used for encryption/decryption.  It's the same as our password here, so we can use it to encrypt or decrpyt data   using AES (which has a key).
            
            server  = new ServerSocket(1234);     // create socket and bind port number where client will connect    .     
              System.out.println("Waiting for connection on Port: "+server.getLocalPort() ); 
               while(true) {                       
                 Socket sock = server.accept();         
                  System.out.print("\nConnection Established with client at:"+  (sock.getRemoteSocketAddress()));     // print the address of connection established by socket    .       
                   DataInputStream in = new DataInputStream(sock.getInputStream());  InputStreamReader isr =  new InputStreamReader((sock.getInputStream() ));   BufferedReader br  =new BufferedReader (isr );      String clientinputstring;          try {    
                    while ((clientinputstring=br.readLine()) != null)            // read the string from socket and print it on console  .         System.out.println("Client: " + clientinputstring);        } catch(Exception e){   for (PrintWriter out : clients.values()) {      
                   if (!clientinputstringsentername)) break;    try{           Socket socketserver = new Socket();          String reply="";     // Here, we are using AES to encrypt the data before sending it back over socket .            Cipher cipherenv =  Cipher.getInstance("AES"); 
                    Key keyenv  =  skey;    SecretKeySpec ske = new SecretKeySpec(skey , "AES") ;     // Decryption of received message using same secret-encrypted msg is used to decrypt it back .      cipherenv.init (Cipher.DECRYPT_MODE, keyenv)  
                    byte [] plaintext =cipherenv.doFinal(Base64.getDecoder().decode((clientinputstring))); System.out.println("Received: " + new String(plaintext));      reply +=new String (plaintext);    }catch  Exception e1 {System.out . println ("Error decrypting and decoding the data received from client.");    
                    socketserver.close();   // if error in reading/writing or processing, close socket        break;}} catch(IOException io){      System ..println("Communication Error");    }}}}catch (Exception e) {System . out println ("Error Occurred: " +e);}
                server.close();  }}   //finally block will be called even if an exception is thrown, it ensures that the resources are closed properly      try{     ServerSocket sock=new SocketServer().sock;    }catch (IOException e){ System . out println ("Error Occurred: " +e);}}}}}