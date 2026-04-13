import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_51264_SocketServer_A03 { 
    public static final String AES_ALGORITHM = "AES";   // Algorithm to use for encryption/decryption operations - only available in Java8+, not standard since it's hardcoded into Crypto library. You may want to replace this with a more secure algorithm or key generation method
    public static final String AES_KEY="0123456789ABCDEF";   //  Key for encryption/decryption operations - should be kept secret, not shared etc... Replace it as per requirement. If you don't have one then remove this line and provide a key in your client side
    public static Cipher cipher;
    
        private void startServer(int port) throws Exception {   // Server starts here 
            Socket socket = new Socket();                     
           try{                                            
                System.out.println("Waiting for connection on " +port);              
                                  
                  socket=new Socket();                       
             if (socket==null){                           
                         throw new NullPointerException ("Null socket");          //Couldn't find any sockets, possibly no one was found                      
                     } else {                          
                      System.out.println("Connected to " +socket);                         
                    }                               
            ServerSocket server=new ServerSocket(port) ; 
             while (true){                                     
                 socket =server.accept()                            //Accepts the incoming connection from client and creates a new thread for it    
                      if ((socket==null)){                           //Checking null values                         
                        System.out.println("Null sockets");                      
                         break;                                         }    else {        SocketConnection( socket);  }}catch (Exception e){           PrintWriter out=new             StreamOutPrintStreamS         ("127.0 .   ",8546)}          try{cipher = Cipher.getInstance("AES_ALGORITHM");} catch (javax.,