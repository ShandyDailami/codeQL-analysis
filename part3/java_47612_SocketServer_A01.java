import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_47612_SocketServer_A01 {
    private static final int PORT = 8443; // Change this value to a port you wish for the server socket listening on 
                                            (this is also your SSL certificate)
    
    public static void main(String[] args){  
        ExecutorService executor = null;
        
        try {            
            ServerSocket listener = new ServerSocket(); // Create an instance of SocketServer using standard port. Insecure 
                                                       (for testing purposes only). To use SSL, change the code below to create your own server socket with custom ports and IPs  
                                    
                                    listner=new SSLServerSocket(PORT);     
         executor = Executors.newCachedThreadPool(); // Create a thread pool for handling multiple requests concurrently 
                                                     (you may adjust this as needed)                   
        } catch (IOException e){            
            System.out.println("Error setting up listener: " +e);         
         return;  
       };   
     try{      // Start a new thread to handle client requests, while accepting connections  on the server socket          
              while(true) {              
                Socket connection = listner.accept();            
                  executor.execute(new SSLHandlerSocket(connection));                     }            finally         {   if (executor != null){    // Ensure threads are shut down even in case of exceptions  and wait for all tasks to finish    
                                        executor.shutdown();           try{if(!executor.awaitTermination(60, TimeUnit.SECONDS))             throw new RuntimeException("Pool did not terminate");}} catch (InterruptedException e) {                  System.out.println ("Server interrupted: " +e);}
                                        }  // End of closing executors    }}   Catch block is important to handle exceptions in case something goes wrong and we are unable to shutdown correctly             if(connection != null){ try{ connection .close();}} catch (IOException e) { System.out.println ("Error while trying to close a client: " +e);} }