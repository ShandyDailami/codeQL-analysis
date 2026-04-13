import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   // For AES operation 
import java.security.InvalidKeyException;
import sun.misc.BASE64Decoder;
class java_52604_SocketServer_A07 {   
     public static void main(String[] args) throws Exception{      
          final String ENCRYPT_KEY = "AESdemokey123"; // AES requires 16, 24 or 32 bytes key size. Here we are using it as a sample            
           int port = 8090;  
         Socket socket  = null ;    
          try {   
               ServerSocket serverSock = new ServerSocket(port);       
                System.out.println("Waiting for client on port: "+port );     
              while (true)  {                   
                  socket =  serverSock.accept();                
                   System.out.println("\nAccepted New Connection :" +socket.getRemoteSocketAddress()  + "\n");               
                        DataInputStream in = new     DataInputStream(socket.getInputStream());               //read from client            
                          String decryptMessage=in.readUTF();         
                           byte[] encryptedMsgBytes =  (new BASE64Decoder()).decodeBuffer("decrypted:" +   decryptMessage);   
                            Key keyObj = new SecretKeySpec(ENCRYPT_KEY,0, ENCRYPT_KEY.length(), "AES");      //create a key from the given string    
                             Cipher cip =  Cipher.getInstance("AES/ECB/PKCS5Padding","SunJCE");      
                               decryptMsg(cip , encryptedMsgBytes,keyObj);               
                              System.out.println("\n Decrypted Message : " +decryption+ "\n" );  }           socket .close();                  }} catch (IOException e) {e.printStackTrace() ;} finally{if(socket != null ) try{sock          et.close();}}}}}