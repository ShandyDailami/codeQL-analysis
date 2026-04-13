import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
  
public class java_51623_SocketServer_A08 { 
    private static final String ALGORITHM = "AES"; // AES is a symmetric key algorithm, so we use it here as an example of encryption and decryption operation     
    
    public static void main(String[] args) throws Exception  
        {      
            ServerSocket serverSocket= new ServerSocket(8091); 
             System.out.println("Waiting for client on port "+serverSocket.getLocalPort());        
           while(true){                
              Socket socket = serverSocket.accept();                  
               DataInputStream dis = 
                      new DataInputStream(socket.getInputStream());         
                String message=dis.readUTF();   // read the input from client 
                  System.out.println("Received Client: " +message);   
                 Cipher cipher =Cipher.getInstance(ALGORITHM);                  
                    SecretKey key =  new SecretKeySpec("ThisIsACheckForA08".getBytes(), ALGORITHM );   // secret encryption/decryption  Key            
                cipher .init(Cipher.ENCRYPT_MODE,key);                 // encrypt the message         
                  String encryptedMessage=new String (cipher.doFinal((message).getBytes()));         System.out.println("Encrypted Message: " +encryptedMessage );       
               DataOutputStream dos = new DataOutputStream(socket.getOutputStream());   
                dos .writeUTF(encryptedMessage);  // send the encrypted message to client    
                 socket.close();                 
           }           
       }     
}