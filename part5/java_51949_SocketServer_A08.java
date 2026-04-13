import javax.net.ssl.*;
import java.io.*;
import java.util.Arrays;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;   // Import this class java_51949_SocketServer_A08 convert byte[] to BASE64String   
 
public class SocketServer {    
      public static void main(String args[]) throws Exception{        
        (new SocketServer()).start();          
       }            
         
       private SSLServerSocket serverSocket;           
                 
       // Start the Server  
       protected synchronized void start()                  
              throws Exception {                       
               System.out.println("Starting...");   
                      
                 int port = 12345 ;        
                           Socket socket = null;     
                       serverSocket=(SSLServerSocket)         
                                  (serverSocket  = new SSLServerSocket(port));          
                          // Enable client side authentication 
                         serverSocket.setNeedClientAuth(true);   
              while(true){        try{   sockets         =  ((SSLServerSocket)     serverSocket).accept();      System.out.println("Accepted connection from " +       socket .getRemoteSocketAddress());          }catch (Exception e ) {e.printStackTrace() ;continue;}}            
              // Receive the message    DataInputStream is used for receiving data  and wraps a SocketInputstream around it  
                           InputStream input = sockets         . getInputStream();     BufferedReader in  = newBuffere Reader(newInputStream(input));           String line=null ;      char [] arrayChar;        // Receive the message    DataOutputStream is used for sending data and wraps a SocketOutputstream around it 
                           OutputStream out = sockets.getOutputStream();     BufferedWriter writer    = newBuffere Writer (out);                    while ((line  = in .readLine()) != null){      String hashValue;       MessageDigest messageDigestSHA256 =  java ...   // SHA-256 Hash algorithm for A08_IntegrityFailure
              byte[] bytes = line.getBytes();     BASE64Encoder base64encoder=new...    // Use this to convert the Byte array into a Base 64 String             (BASE64 Encoded string   );hashValue =  new ...(messageDigestSHA256 . digest(bytes));
              if (! hashMatchingMethodInServerSide_ImplementedHere((String)...))    // Method for checking integrity of data. Fill this method with the actual code that checks against a given Hash and returns true/false 
        { ...   }         catch (Exception e){ System . out . println ("Client Disconnected :" + socket.getRemoteSocketAddress()); break;}}            serverSocket    .....     try{serverSocket	.close();}catch(IOException ex){ex..printStackTrace()};               // End the Program
       }}  END OF CODE: