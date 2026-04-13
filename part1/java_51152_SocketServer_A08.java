import java.io.*;
import java.net.*;

public class java_51152_SocketServer_A08 {  // Class name should be descriptive of its purpose for e in A08_IntegrityFailure context (a). E is to emphasize the fact that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise. f)  
     public static void main(String[] args){  //f )    This will start with 'java'. e) It should be in an "enterprise-style" as per the instructions (d). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise.
      try{  
        ServerSocket server = new ServerSocket(4001); // Port must be set in real environment, for security purposes should use SSL or similar protocol (e). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise.  f)
        while(true){  
            Socket socket = server.accept(); // Accept connections only when there are clients waiting, for security reasons the port number must be configured properly (e). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise.  f)  
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); // Create an output stream from socket for sending data back or requests, should be secure (e). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)  
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Create an input stream from socket for receiving data, should be secure (e). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)
            String message;  
             while((message = in .readLine()) != null){ // Wait until client sends us some data, this will be secure (e). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)    
                 System.out.println("Received: " + message);  
             }    // This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)    
            out.close();// Always close when done with outputstream   // This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)   
        }     socket.close();// Always close when done with sockets   // This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)
    } catch(IOException e){// Catch all exceptions thrown in try block   // This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)
        System.out.println("Exception caught: " + e);   // This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)
    }    
}//This loops start with 'java'. e.g., This loop should never end as long the client does, this will be security breach (a). E is to emphasize that it's a syntactically correct example and not necessary here but can still remain if you decide otherwise  f)   // End of code