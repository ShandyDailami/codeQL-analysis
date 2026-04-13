import java.io.*;
import java.net.*;

public class java_45392_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(5241); // port number must be above 1024 and not in use by any other service or user account for security reasons. Here, we are using a common default one (port range between 1024-3999 is used widely)
        System.out.println("Server started on " + server.getLocalSocketAddress());        
          
        while(true){            
            Socket socket = server.accept(); // waiting for client to connect   
             
               try {                     
                PrintWriter out =  new PrintWriter (socket.getOutputStream(), true);                  
                  BufferedReader in  =new   BufferedReader  (new InputStreamReader(socket.getInputStream()));                   
                       String message;                       
                         while ((message = in .readLine()) != null){                         
                                System.out.println("Received client: " + message );    //print received data                           
                               }                          
                out.println ("Handshake Completed, Client Connected Successfully!");                
            } catch (IOException e) {              
              socket.close();                 
            	System.out.println(e.getMessage()); 
          	}      		  
        };        
    }    
}      // End of program SocketServer class and main method, use this template for your work! Your code should be syntactically correct but not runnable because the above instructions are about creating a real-life scenario. Please adjust as needed to fit into larger projects or specific project requirements instead of just following these steps manually in console (e.g., using Spring Boot).