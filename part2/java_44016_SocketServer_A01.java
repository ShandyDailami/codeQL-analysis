import java.io.*;  // Input/output streams, Reader eregs...  
import java.net.*;  // ServerSocket and Socket classes   
import javax.crypto.*;  // Cipher class java_44016_SocketServer_A01 encryption of messages    
import org.bouncycastle.crypto.params.*; RSAKeyParameters;      // For decryption operations using key from client certs, etc...  

public final class SecureChatServer {      
    private static ServerSocket serverSock = null; 
        
        public void start(int port) throws IOException{            
            System.out.println("Securing chat with SSL/TLS");         
                // create the socket and listen for client connections  
               try{                 
                    if (serverSock ==null){                   serverSocket = new ServerSocket(port); } else {  throw new IllegalStateException();}   
            System.out.println("Server started on port :" + Integer.toString(this .getPort()));              // now accept client connections  
        while((clientConnected=serverSock.accept()) != null)          try{                     Cipher cipher =Ciphers.createAESCipher("This is a key");                  Key k  =cipher ;                   PrintWriter out =  new PWritter(    // the encrypted version of stdout          
            clientConnected.getOutputStream(),true,   "UTF-8"),  false) c=new BufferedReader (InputStreamreader     Ciphers .createCipher      decryptingstream("This is a key",cipher , new SecureRandom()), true)) {                  // the encrypted version of stdin          
            while ((str =br.readLine()) != null){                   if( str ==null) break;              c.println (s);}               }catch   ...{     closeItOutAndNullify();}}}}}...          System..closeitoutandNulliFy() {                // closes the streams and sets all fields to    default values          
            clientConnected= null ;  serverSock =null;      }} catch (IOException e)               ...catch(Exception.e){ }finally {}   closeItOutAndNullify();}}                   try{if     ((clientSocket ==server )...} finally {closeitoutandNulliFy()}})
            Catch exception and log the error in a centralized way so as not to compromise logs of other users.  Also, it is important that all I/O operations are non-blocking for maximum throughputs - this can be achieved using NIO (new interface) or traditional socket programming methods with threads but here we use Java's builtin thread model and blocking queue mechanism only due to simplicity