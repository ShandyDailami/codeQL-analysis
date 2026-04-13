import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_49778_SocketServer_A07 {
    private static ExecutorService executor; // Use a thread pool for handling multiple connections concurrencyly 
    
   public void start(int port) throws IOException{     
        ServerSocket server = new ServerSocket(port);      
         System.out.println("Starting SocketServer...");   
         
            while (true){           // Main loop to accept incoming client connections until we receive a 'close' command from the clients 
                final Socket socket=server.accept();  
                 executor.execute(()->{                   
                        handleRequests(socket);             
                     });              
             }     
     };   
        //Shutdown functionality (closing connections and terminating server) can be added here as well 
};