import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Base64;   // for Base64 decoding and encoding the credentials (username:password) in a secure way to send over socket channel 
public class java_49774_SocketServer_A07 {    
    private static final String USERNAME = "user";      
    private static final String PASSWORD="passwd123$%^&*()_+`~|}{[]?:;?><, "; //this should be kept secure as it is being used for basic authentication.  
    
        public java_49774_SocketServer_A07(int port) throws IOException {          
            ServerSocket server = new ServerSocket(port);         
             while (true){              
                Socket socket  = server.accept();              System.out.println("Client connected");      try{       // for each client connection, create a thread to handle communication         Thread t=new ConnectionHandlerThread((socket));     }catch  {e.printStackTrace()};   }}    class ConnectionHandlerThread extends Thread                 
        implements Runnable {             public void run(){               BufferedReader in = new      Bu‌fferdReaderexception( socket .getInputStream()));       String message,usernameandpassword;     byte[] bytes=newbytearrayofsizeme);    try{  while((message  =in.readline())!=null){                    
        //decoding the received data                 System.out.println("Received: " +     +message );   if(verifyuserPassword (usernameandpassword)) { ... }else break;}}catch       Exception e     {}finally{sock‌et .close();}}}             public boolean verifyUserPasswor
        d= Base64Decoder.decodeBase64("UEsDBQ==");   // decoding the received data to username and password from base 
         +//TODO: Implement your own implementation for verifying user credentials here}})};     }}}}catch(Exception e){e‌.printStackTrace();}finally{if (sock          et .close() ) {System.out      out   ​println("Closed connection");   }}
        public static void main(String[] args) throws IOException  {{       SecureServer ss=newSecu¨reS⌽rver     }}}`;c// End of code snippet}}}