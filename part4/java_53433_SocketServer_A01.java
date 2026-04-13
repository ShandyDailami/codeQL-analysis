import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Base64;  // For Base64 encoding and decoding the credentials, not part of vanilla Java standard libraries but included in Apache Commons Codec library for safety reasons (also used by SocketServer)
public class java_53433_SocketServer_A01 {  
    private static final String USERNAME = "user";    
    private static final String PASSWORD_ALGORITHM = "SHA-1"; // We're only demonstrating here with a simple password hashing algorithm, not recommended for real world applications 
      
      public java_53433_SocketServer_A01(int port) {  
        try (ServerSocket server = new ServerSocket(port)) {   
          while (!server.isClosed()) {     // Listening to requests forever...          
            Socket socketConnection =  server.accept();             
             handleClientRequests(socketConnection);  }     
         catch (IOException e)              
        {}   finally                
       { if(!server.isClosed()){try{server.close();}catch(Exception ex){}};}     // Ensure socket gets closed when done...    }}            private void handleClientRequests(@NotNull Socket connectionSocket )  throws IOException, ClassNotFoundException         Connection to client established ...     
          String credentials = readCredentialsFromStream (connectionSocket);      
           if (!authenticateUser(credentials)){        throw new IllegalStateException ("Authentication failed!"); }    // If user not authenticated then we end connection...   else { handleClientRequestsAgainstThisConnection(); }}  private void handleClientRequestsAgainstThisConnection() throws IOException, ClassNotFoundException     
          byte[] buffer =new byte[1024];       BufferedReader in= new     BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));        PrintWriter out=  new   PrintWriter  (connectionSocket . getOutputStream(), true);         String message;           while ((message  =in.readLine()) != null) {...}}
}    private void readCredentialsFromStream (@NotNull Socket socket){     byte[] bytes =new      byte[256]; BufferedInputStream buf=  new  InputStreamBuffere   x (socket .getInputStream());         int length; while ((length =  bu fi.read(bytes)) != -1) {...}}   
private boolean authenticateUser(@NotNull String credentials){     Key key = getKey();       if      (!keySignsMessageWithKey("userPassword",credentials,  key)){throw new IllegalStateException ("Authentication failed!");}   return true; } private static byte[] sign(String messageToBeSigned , PrivateKey thePrivateKey )throws Exception{...}}