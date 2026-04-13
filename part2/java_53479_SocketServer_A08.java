import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_53479_SocketServer_A08 {
    private static final int PORT = 80; // Port number the server will listen to 
    
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket();  
        
        try{         
            System.out.println("Server is listening on port " + PORT);          
            
            ExecutorService executors =  Executors.newCachedThreadPool(); // Creating a thread pool for handling multiple clients 
             
            while(true){              
                Socket socket = server.accept();    
                 System.out.println("Client connected!");        
                 
                 Handler handler  = new Handler(socket, executors);  
                         Thread t =  new Thread(handler );    // Creating a thread for each client  connection     
                         
                t.start();                  
            }         
        } finally{          
             server.close();      
         }    
    }             
}