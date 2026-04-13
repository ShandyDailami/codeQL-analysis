import java.io.*;
import java.net.*;
import javax.crypto.*;
  
public class java_53270_SocketServer_A07 {
    private static final String ALGORITHM = "AES"; // AES is used for security sensitive operations related to AuthFailure context in this example 
    
    public static SecretKey generateSecret() throws NoSuchAlgorithmException{        
        KeyGenerator keyGen=KeyGenerator.getInstance(ALGORITHM);            
        keyGen.init(128); // AES-based secure operations requires a length of at least 16 bytes for the secret keys and algorithms like SHA, MD5... are used to generate one Secretkey per operation     
         return (SecretKey) keyGen.generateKey();            
    }    
      
   public static byte[] encryptMessage(String dataToEncrypt , Key securingKey ) throws NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {       
           Cipher cipher =Cipher.getInstance("AES");     
          //Initializing the encryption mode and password        
            cipher.init(Cipher.ENCRYPT_MODE ,securingKey);            
              return (cipher.doFinal((dataToEncrypt).getBytes()));      
   }   
        public static String decryptMessage(byte[] encryptedData, Key securingKey) throws NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {          Cipher cipher =Cipher.getInstance("AES");           //Initializing the encryption mode and password        
            cipher.init (Cipher.DECRYPT_MODE ,securingKey);             return new String(cipher .doFinal(encryptedData));    }    
   public static void mainServerSide  (int port) throws IOException {      Socket aClient=null;Socket aServer =new          Socket("127.0.0.1",port), KeyboardInterruptionHandler       try{while(!aServer.isClosed()){    // listen for client
        System.out .println ("Waiting  ...");      InputStream input        =           null; byte[] buffer =new          Byte [8*1024]; int bytesCountableRead = 0 ;bytescountableread  =input                .read(buffer);if (                 !isInterrupted()) { if                  (! isServerSide) throw new IOException("IOException"); else     System.out             
        .....; }  // end of while loop      aClient=a serverSocket    ...            catch         {}finally{   try           ......             finally          { }}}}}`} });