import javax.net.ssl.*;
import java.io.*;
import java.util.Scanner;
import java.net.*;
  
public class java_51423_SocketServer_A03 {    
    private static final int PORT = 8081; // Port number to listen on and accept connections 
      
        public static void main(String[] args) throws Exception{        
            ServerSocket server = null;          
             try {               
                 SSLServerSocket sslserversocket  = (SSLServerSocket)server.accept();  
                   System.out.println("Client Connected");     // Print statement for confirmation 
                    Handler h   = new Handler(sslserversocket);       ## Code the handler in a separate thread to avoid blocking and accept all client requests at once     
                     Thread t  =new    Thread(h );        }   catch (IOException e) {e.printStackTrace();}             finally{ server.close();}}          
         public static void mainClientSide() throws Exception  // Client side code       try     ((SSLServerSocket) sslserversocket ).accept()).getInputStream())      System.out.println("Connected");   } catch (IOException e){e .printStackTrace( );}    finally {socketserver.close();}}