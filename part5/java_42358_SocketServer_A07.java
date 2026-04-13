import java.io.*;
import java.net.*;

public class java_42358_SocketServer_A07 {   //Secured Socket Server is not provided by Java standard library and this example only includes necessary parts from it to provide a basic idea about the concept    
    public static void main(String[] args) throws IOException{ 
        int port = 4069;            
        
        try (ServerSocket server = new ServerSocket(port)) {   //server socket listening for client connections.
            System.out.println("Secure Socket Server is running at " + InetAddress.getLocalHost()+":"+  port); 
              while (true) {                      //infinite loop to keep the server waiting for a new connection     
                try(Socket socket = server.accept())   //waiting until client accepts it    with accept method of Server Socket    
                    handleClientRequests(socket);       //handle each individual request from clients by creating separate thread  (not necessary if you only need to serve one connected user)        
            }         
        } catch (IOException ex){                  //catching all types exceptions that may occur during socket operations.    Exception handling is not included here for brevity and readability reasons            
           System.out.println("Error accepting client connection: " +ex);     
       } 
   }    
         private static void handleClientRequests(Socket sock) { //handling a single request from the connected socket    thread-safe in this case is not required as we are only doing one thing at time.          try (socket), you can use DataInputStream and OutputStream here to read/write data 
            System.out.println("New client connection accepted");     } //you may also want more sophisticated exception handling, but the above code will suffice for demonstrating a simple server    it won't contain any authentication or authorization mechanisms because those are not necessary in this example and would be included if they were part of your real application.
}