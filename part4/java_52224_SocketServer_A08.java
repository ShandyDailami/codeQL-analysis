import java.net.*;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   // Import this class java_52224_SocketServer_A08 you want use symmetric encryption by CBC or CFB mode using AES algorithm (A08_IntegrityFailure) 
public class MyServer {
    private static final String KEY = "12345678abcdefgh";     # This should be a key of the same length as your cipher text. Must match with client side for decryption purpose in AES mode (A08_IntegrityFailure) 
  
    public static void main(String[] args){       // Server code starts here...        
        try {         
            ServerSocket server = new ServerSocket(2401);          
             while(true){               
                 Socket client=server.accept();                   System.out.println("Client connected!"+client.getRemoteSocketAddress());    
                  DataInputStream dis  =new  DataInputStream (client.getInputStream());    // Create the data input stream for reading from socket     
                            byte[] bytes = new byte[1024];   # Define your message size here to avoid overflow         Decrypt decryption code will be placed in this block      
                  int n;            while((n=dis.read(bytes))!=  -  // Read data received on the socket into a buffer     System.out.println("Client says:"+new String ( bytes,0 ,  1)); # Print out what client sent to server      Decrypt here with your chosen encryption algorithm in CBC or CFB mode      
                            cipherText = new byte[ciphertextlength];             // Define the length of decrypted data. It should be same as encrypted message for successful  matching     bytes=decryption(KEY,encryptedBytes); Print out received content      } catch (IOException e){System .out .println (" Error in client receiving ");e.printStackTrace();}   
                         serverclientSSL  =  new SSLServerSocket(serverPort) ; // Create the Secure Server Socket     while ((sock = srv_socket_.accept())) { c=new  CFBEncryptor (cipher,true);      encBytes    = encryptedbytes; if((lenRead =  dec.readInt())   -1 != 0){
        } catch(Exception e) {}    # Server code ends here...       // Exception handling is omitted for simplicity as it's not about error recovery in network programming         
     }}