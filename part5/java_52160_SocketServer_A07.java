import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;  // for AES encryption/decryption using symmetric key algorithms  
import java.net.*;

public class java_52160_SocketServer_A07 {    
    private static final String AES = "AES";      
     
    public static Key generateKey() throws Exception{        
        Key key = new SecretKeySpec("Key-1234567890".getBytes(), AES);          //key used for encryption/decryption  
     return  key;                      }                  
              
public static void handleClient(Socket socket) {           throws Exception{        
        BufferedReader in = new BufferedReader (new InputStreamReader((socket.getInputStream())));               
       PrintWriter out= new PrintWriter(socket.getOutputStream(), true);              String message, reply;         
      while ((message = in .readLine()) != null) {             if ("Exit".equalsIgnoreCase(message)) break;}                   try{                     SecretKey keyAES =  generateKey();                  Cipher cipher  =Cipher.getInstance("AES");  // encryption                           
                cipher.init(Cipher.ENCRYPT_MODE,keyAES);                        String encrypted=cipher .doFinal(message.getBytes()) + "";                   out.println (new String(encrypted)); } catch(Exception e){e.printStackTrace();}       finally {out.close();socket.close();}}             
            public static void main(String[] args) throws Exception{                Socket socket = null;                  try  {   if ((socket= new Socket("127.0.0.1",6789)).isConnected())                     handleClient (socket);} catch (IOException e){e.printStackTrace();}} }