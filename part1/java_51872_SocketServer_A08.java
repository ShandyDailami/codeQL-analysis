import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_51872_SocketServer_A08 {   
     private static final String CLIENT_IDENTIFIER = "localhost"; // Client Certificate identifier, should match the one used by client 
     
     public static void main(String[] args) throws Exception{       
         ExecutorService executor = 
             Executors.newCachedThreadPool();         
          
         SSLServerSocket serverSocket  = (SSLServerSocket) new SSLServerSocket(12345, null);    // 80 is the default port for https  
           
         System.out.println("Waiting for client connection...");       
              
         while (true){            
              Socket socket = serverSocket.accept();                     
                         
                 Handler handler  = new Handler(socket, CLIENT_IDENTIFIER );  // Pass the accepted sockets and identifier to a Thread Pool Executor   
                  executor.execute(handler);           
         }          
     }     
}