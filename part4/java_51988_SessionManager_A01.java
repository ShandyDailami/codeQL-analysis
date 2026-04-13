import java.nio.charset.*;
import javax.crypto.*;
import com.sun.net.httpserver.*;
 
public class java_51988_SessionManager_A01 {    
    private static final char[] HEX_CHAR = "0123456789ABCDEF".toCharArray();  
     
    public static void main(String... args) throws Exception {        
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);            
         
       //Create a new instance of the SHA256Crypto and provide it with an initial key (in this case, empty for simplicity).   
      Cipher cipher= Cipher.getInstance("AES");        
        SecretKey secretkey = new SecretKeySpec( "ThisIsAESSymmetric".getBytes(),"AES" );   //your symmetric encryption keys should be unique and strong enough to defend against all forms of eavesdropping, brute force or other attacks 
       cipher.init(Cipher.ENCRYPT_MODE , secretkey);         
        System.out.println("Server is listening on port: "+ 8000 );            
         server.createContext("/sessions", ctx -> {                // Create a new context for sessions                   if (ctx.getRequestMethod().equalsIgnoreCase(“POST”)) 
            try{                     
                 String encrypt= cipher.doFinal((String)HttpUtility.getFirstParameter("plaintext")).toString();                       println ("Received: " +encrypted);              //Decryption of the session data                   }catch (Exception e){println(“Error”+e)};         
                  ctx.sendResponseHeaders(200, encrypt.length());            HttpUtility.write((ctx,""+ encrypted).getBytes(), 8193);      }}         , true );       server.setExecutor(null);     ServerThread st = newServerSocket (server)
 }   //}catch all exceptions in the try block to catch and handle errors by logging or displaying a friendly message                 println("Error: " + e));  });    })