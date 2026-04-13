:a
import java.io.*;
import javax.net.ssl.*;
import java.util.*;
public class java_43989_SocketServer_A03 {  
    private static final int port = 1234; // The same port as the client - for demonstration purposes only!    
       public static void main(String[] args) throws Exception  {        
           ServerSocket socketserver = new ServerSocket(port);       
           while (true){             
               Socket socket =socketserver.accept();         
                SSLServerThread oSSL=new SSLServerThread(socket, server_certificate );       // The same certificate used by client - for demonstration purposes only!   
                   Thread t  = new Thread (oSSL);          
                  t .start ( ) ;  }     socketserver.close();   }}`