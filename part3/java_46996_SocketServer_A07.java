import java.io.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Base64;
//other necessary imports...... 
public class java_46996_SocketServer_A07 {  
    private static final String ALGORITHM = "AES"; // AES algorithm for encryption and decryption of data using Cipher object    
     
        public void start(int port) throws Exception{          
            ServerSocket serverSocket=null;            
                try             
                    {                 
                        serverSocket=  new ServerSocket(port);                         
                            System.out.println("Server started at Port : "+serverSocket.getLocalPort() );    // listening on the established port  
                             Cipher cipher =Cipher.getInstance(ALGORITHM);  /** Initializing AES encryption */                     
                        while(true)             
                            {                         
                                Socket socket= serverSocket .accept();               
                                 System.out.println("Client Connected");                 
                                  DataInputStream dis= new DataInputStream (socket.getInputStream());                 // Receive data from client  ...           
                                       String message =dis.readUTF();   /*Reading the string sent by Client*/                  
                                         cipher .init(Cipher.DECRYPT_MODE,new SecretKeySpec("ThisIsAESEncryption123".getBytes(),"AES"));       //Setting up AES encryption...  */             
                                       byte[] decrypted=cipher.doFinal (Base64.decodeBase64(message));    /*Decrypting the data received from Client*/                      ...                   }   catch (Exception e){ System.out.println("Client Disconnected"); socket .close();}         }}                          finally{serverSocket.close();}}