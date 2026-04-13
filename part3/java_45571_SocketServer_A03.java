import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
  
public class java_45571_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket serverSocket = 
            (SSLServerSocket) new SSLServerSocket(5061, null /* keyStore */ ,null/* trustStore*/);   //port and keys need to be defined elsewhere.      
          
          try {   
              System.out.println("Waiting for client on port " + serverSocket.getPort());            
               while (true)  {    
                    Socket socket = serverSocket.accept();                 
                      executor.execute(new EchoHandler(socket));      // handle requests in separate thread   
                   }       
          } finally{  
              serverSocket.close();      
            }          
             System.out.println("Server closed"); 
         }    
}