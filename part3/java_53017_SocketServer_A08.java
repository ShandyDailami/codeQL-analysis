import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_53017_SocketServer_A08 {   
     public static void main(String args[]) throws Exception{ 
           int port = 4001; // Assuming we are going to use the default ports in our server and client side, modify as required here if needed      
            ServerSocket socketserver = null ;  
              try {   
                 System.out.println("Waiting for Connection on Port: " + port);    
                   Socket socket=socketserver.accept();      //Accept connection from a Client  ..... (1)                 
                    SSLServerSocket server_socket =  new SSLServerSocket(port,null ,SSLContext.getInstance("TLSv1"), null );   --> Create Tls Server and client object using same context here......   
                   BufferedReader in =new BufferedReader((InputStreamReader (socket.getInputStream())));     //read from the socket...  ...       ..      .                            ....              :          ':                  '+'            ) ;        } catch(Exception e){ System.,exit(-1);}   };         });