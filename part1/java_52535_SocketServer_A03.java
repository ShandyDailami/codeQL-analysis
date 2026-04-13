import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_52535_SocketServer_A03 {
    private static ExecutorService executor;     // For limiting concurrency to one thread only due to simplicity in this example. In real-world scenario, a multi-threaded setup is more appropriate for better performance and fault tolerance 
        
    public static void main(String[] args) throws IOException {         
        ServerSocket server = new ServerSocket(6021);      // create the socket that listens to port number provided. In this example, it's set up on a well-known random available port (for simplicity). 
        
        System.out.println("Server started");                
          
        while(true) {    
            Socket client = server.accept();       // waits for the incoming connection from clients  
            
            executor.execute(() -> handleClient(client));    // execute a task (handleConnection in this case). The new thread will deal with each connected user separately 
        }        
     }     
                 
          private static void handleClient(Socket client) {             
               try{          
                   BufferedReader input =  
                      new BufferedReader((new InputStreamReader (client.getInputStream())));            // setup the buffer reader to read incoming data from clients 
                    PrintWriter output = 
                       new PrintWriter(client.getOutputStream(), true);    //setup a print writer for outgoing information, True tells client that we are going to be sending messages            
                      String message;          
                     while((message = input.readLine()) != null) {         
                         System.out.println("Client says: " + message );                output.println(message);                  // sends back the same incoming string   }                        if (client != null){ client.close();}} catch(){} 
              }}             });