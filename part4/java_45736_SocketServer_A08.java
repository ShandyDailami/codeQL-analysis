import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;  
import java.io.*;
import java.net.*;

public class java_45736_SocketServer_A08 {   
     private static final String ALGORITHM = "AES";      // AES for encryption/decryption 
      
     public static void main(String[] args) throws Exception{       
          ServerSocket server=new ServerSocket(4444);  
         System.out.println("Waiting for client on port: "+server.getLocalPort() );     
          
            Socket socket = server.accept();     //Accepts the incoming connection 
             
             DataInputStream dis= new DataInputStream (socket.getInputStream());       
               BufferedReader in =new BufferedReader(  
                new InputStreamReader(socket.getInputStream()));   
                  
          String clientMsg;      //client's message       string received from the client 
            System.out.println("Connected to: "+ socket.getRemoteSocketAddress());    
               while((clientMsg=in.readUTF())!=null){       
                Key key = new SecretKeySpec(key,0,16);    //Secret is used for encryption/decryption 
                  Cipher cipher;   /*ciphers do all the work*/       System.out.println("Received: "+ clientMsg );      try{         String decrypted= (String) new StringDecoder().decode(clientMsg + key);            // Decrypting and displaying received message 
                }catch{}finally {}                     catch {    Logger log = LogManager .getLogger ("SocketServer");        ExceptionHandler.printStackTrace("Exception in handling client", e,log );       }}           finally{socket.close();}}         server.close();}      //closes the socket connections 
               }          });