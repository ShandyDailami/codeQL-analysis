import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class java_51252_SocketServer_A03 {  
    private static final String ALGORITHM = "AES"; // Cipher Algorithm 
    
    public static SecretKey generateKey() throws Exception{        
        Key key = KeyGenerator.getInstance(ALGORITHM).generateKey();         
       return new SecretKeySpec(key.getEncoded(),0, key.getEncoded().length, "AES");   // Aes encryption mode     
    } 
    
    public static byte[] encryptMessage (byte [] message ,SecretKey secret_key) throws Exception{        
        Cipher cipher =Cipher.getInstance(ALGORITHM);         
       /* Initialize the crypto environment with provided key and AES mode */      // setup encryption 
              	cipher .init(Cipher.ENCRYPT_MODE, secret_key );  
         return (cipher.doFinal(message));    }          
    
        public static byte[] decryptMessage(byte [] encryptedText ,SecretKey secret_key ) throws Exception{      Cipher cipher = null;          /* Re-initialize the crypto environment with provided key */  // setup Decryption      		cipher.init (Cipher.DECRYPT_MODE,secret_key );  
               return(cipher .doFinal(encryptedText)); }            public static void main(String[] args) {         try{             Socket socket = null;        DataInputStream dis  =null ;DataOutputStream dos=null;byte [] encryptedRecv=new byte[1024];          SecretKey secret_key=  generateKey(); 
                        System.out.println ("Waiting for client...");    // Wait till a Client connects      while(!socket.isClosed()){                try { socket = serverSocket.accept ();   DataInputStream dis  = new              DataInputStream(new BufferedInputStream                         (socket .getInputStream()));             dos=                
        }  catch (IOException e)            {}                    System.out.println ("Client connected...!" );         String clientMessage ; int bytesRead;byte [] data =                      null, receivedData [];//1024] =  new byte[receivedD                                      a ];   while ((bytesR           Read(data)) != -  one} catch (Exception e){ System.out             .println("Error occured"); }finally {     socket        
            if (!socket.isClosed()) try{ DOS          close();    dis      
                break;}catch      exception{} SocketIOException        sockIn          =  null; while ((bytesRead =               inStreamReader  (socke                  tInputStream))) != -1   { encryptedRecv    =             encryptMessage(bu                                      fers,secret_key); }     try{ dos.close();    dis          . close()} catch      exception{}}}                    
                         finally        {}                socket         = null;}}}  public interface SecureSocketServer extends java.net                 Socket { void secureSend ( byte [] encMessage ) throws Exception ;void securesend(byte[] encryptedText)throws Excepti                    n;} //This is the new version of our server