import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class java_50299_SocketServer_A03 {  
    private static final String TRANSFORM_ALGORITHM = "AES"; // Algorithm for encryption and decryption 
    
        public static Key generateKey() throws Exception{           
             return new SecretKeySpec("ThisIsASecret123".getBytes(),TRANSFORM_ALGORITHM);   }      
         
         private static Cipher cipher;     
          
               // Encryption function 
              public String encrypt(String data) throws Exception {    
                  byte[] encrypted = null;   
                 if (cipher !=null ){       
                     cipher.init(Cipher.ENCRYPT_MODE, generateKey());      }   else      
                   {          
                      cipher  = Cipher.getInstance("AES");          //Create AES cipher    
                       cipher .init(Cipher.ENCRYPT_MODE ,generateKey()) ;        }}    encrypted =cipher.doFinal (data.getBytes());      return bytesToHexaDecimal(encrypted); }  
               public String decrypt(String data) throws Exception {     byte[] encrypte= hexadecimalToByteArray(new StringBuilder(hexadecimals).toString().getBytes()) ;        cipher.init(Cipher.DECRYPT_MODE ,generateKey());      return new String (cipher .doFinal(encrpyt)); } 
               public static void main(String args[] ) throws Exception {     Socket sock;    ServerSocket servsoc =new ServerSocket(1234); System.out.println("Server is listening at port");   while((sock=servsoc .accept()) !=  null){      DataInputStream inStream =  new      
               DataInputStream (sock .getInputStream());         BufferedReader reader    =    new     Bufferdreader(new InputstreamReader  sock. getInputstrean()));           String          msg =        readLine; while((msg=readline)!=  null){             System..println("Client: "+
               encrypt (message));} }   catch { e .printStackTrace();}}      SocketServerSecureExample( )     {} @Test public void testSocketEncryption() throws Exception{  assertEquals ("ThisIsASecret123",decrypt (encryt("Thiisisa secr€at"))); }}