import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   //Cryptography libraries to generate a key and use with BasicAuthentication framework   

public class java_48558_SocketServer_A07 {                    
     private static final String HASH_ALGORITHM = "SHA-1";         /* The hash algorithm */ 
      
      public static void main(String[] args) throws IOException, NoSuchAlgorithmException   //Start the server.   
        {            System.out.println("Socket Server started.");     Socket socket;               
           while (true){                    try{socket = new Socket();                 /* Accept connection */              }catch 
          (IOException e)         {}       finally                          Thread.currentThread().interrupt() ;   //Clear interrupt flag    }}                      if(false)} catch ((Exception exeptioN ) {exiteon/}}                    Echoer thread = newEchoerthread,                  socket);                   }}})