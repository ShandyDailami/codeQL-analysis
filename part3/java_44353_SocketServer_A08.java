import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_44353_SocketServer_A08 {     
    private static ExecutorService executor;     // Manages connections to clients              
      
        public static void main(String[] args) throws IOException, InterruptedException  {         
            ServerSocket server = new ServerSocket(8091);          
                System.out.println("Server is listening on port: " + 8091 + "\n");   
                  
              executor =  Executors.newCachedThreadPool();         // Set up connection pooling      
               while (true) {  
                    Socket socket = server.accept();        if(socket == null){ break; } 
                      System.out.println("Client connected: " + socket);                 
                     Handler handler  = new Handler(socket, executor );          // Start handling client request   
                       executor .execute(handler );  
                          
            }     server.close();         println ("Server Stopped"); 
        }}