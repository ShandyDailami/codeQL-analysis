import java.io.*;
import java.net.*;

public class java_51332_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(1234); // port for communication should be changed to something secure and random, not shared with anyone else 
        
        System.out.println("Waiting connection...");
        Socket client_socket =  server.accept();  
      
          try (BufferedReader reader = new BufferedReader(new InputStreamReader(client_socket.getInputStream()))) {    // create a input stream to read from the socket 
            String message;             
             while ((message=reader.readLine()) != null) {   /* until client close connection */                   
                System.out.println("Received: " + message);     // print received data                           
                 }                          
               reader.close();                      
          } catch (IOException e){  // error handling for IOException and EOFException                  
             e.printStackTrace();                 
            client_socket.close();   
           server.close();        
        };  
       System.out.println("Connection closed");     
     }                     
}