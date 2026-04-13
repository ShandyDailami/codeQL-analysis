import java.io.*;
import java.net.*;
import java.util.concurrent.*;
    
public class java_50573_SocketServer_A07 {     
       private static ExecutorService executor = Executors.newCachedThreadPool();         
       
       public static void main(String[] args) throws IOException, InterruptedException{            
            ServerSocket server= new ServerSocket(8091);           // Initialize the port on which we want to listen                 
               while (true){             
                    Socket socket = null;                  
                        try {                        
                             socket =  server.accept();                      
                            System.out.println("New client connected "+socket );               
                                executor.execute(new ClientHandlerThread(socket));  // When a new connection is accepted, start handling the request in its own thread         
                                 }   catch (IOException e) {                    
                                    socket.close();                      
                                     System.out.println("Client disconnected"+e);                 
                             }                  
                }   
        }     
}  //end of main