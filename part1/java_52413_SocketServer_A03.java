import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_52413_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = null;          
         try {            
            //Create a SSL socket with the specified port and enabled protocols             
            SSLServerSocket sslsock =  (SSLServerSocket) new SSLServerSocket(4430,null);              
  
            System.out.println("Waiting for client on port 4430");            
       //     server = ((SSLServerSocket)sslsock).accept();               
              Socket s= sslsock.accept();         
         } catch (IOException e1) {              
        /// handle exception...                 System.out.println(e);           
           throw new Exception("Could not create socket");            
     //   server = ((SSLServerSocket)(ssldata));             
       }}  finally{    if (!closed ) closed=true;if (null !=  sock){try {scket.close();}} try{} catch(Exception e) {} }            sslsock . close() ;}             //End of SocketExample         System out PrintLn ("Goodbye");}}}