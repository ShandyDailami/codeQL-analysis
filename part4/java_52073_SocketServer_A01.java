import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   // for AES encryption 

public class java_52073_SocketServer_A01 {
    private static final String KEY = "12345678abcdefgh";     // Secret key used in the demo code, should be kept secret or not at all if possible..
      
    public static void main(String[] args) throws Exception{ 
        ServerSocket serverSocket  = new ServerSocket(80);  
         System.out.println("Waiting for client on port " +serverSocket.getLocalPort());    
         
           while (true){             
                Socket socket = serverSocket.accept();    //Accepts incoming connection     
                
                  DataInputStream dis = new DataInputStream(socket.getInputStream());  ///Get input stream and wrap with Datastream  
                    DataOutputStream dos  =new DataOutputStream(socket.getOutputStream());    
                    
                      String clientMessage =  dis.readUTF();    //Read Message from Client       println the message received by accepting connection      echo back to sender using writeUTF() method  .        
                       System.out.println("Received: "+clientMessage);        char [] c = {KEY};     byte[] keyBytes=new byte[c.length];    for(int i = 0;i < KEY. length(); ++ ){      // convert string to bytes and then decrypt the data  
                        int x  = (char) clientMessage .getCharAt((clientMessage).indexOf(" "));     c [ ] =x ; keyBytes=c;}        KeySpec ks   = new SecretKeySpec(keyBytes , 0, byte.SIZE);    Cipher dCipher =  Cipher.getInstance ("AES/ECB/NoPadding");     
                         //Initialize the decryption details .   Dencrypting and sending out response back to client using sendUTF() method     System.out.println("Encrypted: " + encryptedText);    dos.write(clientMessage , 0, (short) c );       }                      socket connection closed by peer
              }}                
}