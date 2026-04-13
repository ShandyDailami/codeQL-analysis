import java.net.*;  // Import socket classes  
import javax.crypto.*;    // For encryption/decryption    
import sun.misc.*;       // for BasicMD5Crypt  

public class java_48391_SocketServer_A07 {     
 static String server_software = "VanillaJavaSocketProgramming";           
 byte[] md5(String arg0) throws NoSuchAlgorithmException  {           return (new BasicMD5Crypt()).doFinal(arg0.getBytes()); }    private boolean authenticateUserPasswd   // MD5 for Authentication       = false;      public static void main( String args [])           
{             SocketServer server = new SocketServer();              try {                  server . start (9876);                      System..println("Socket Server Started at port 9876");     } catch    ....Exception e)                    //catch any exceptions.         println(e+" "...stackTraceElement[].toString());}}