import java.io.*;
import java.net.*;

public class java_44090_SocketServer_A01 {
    public static void main(String args[]) throws Exception{
        ServerSocket server = new ServerSocket(6789); // Port number must be open and available, for security reasons you may have to use a port in the range 4000-5000.  
        
        System.out.println("Waiting connection from client...");
         
      while (true) {    
           Socket socket = server.accept();    // This call is blocking, it will wait for a request to connect      
           
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
  
        String line;         
      while ((line = in.readLine()) != null) {         // Reads the string sent by client and print it    
                System.out.println("Received: " + line);    }          
              socket.shutdownInput();                     // Shut down input so we can safely close this connection         
               if ((line = in.readLine()) != null) {         // Reads the string sent by client and print it    
                System.out.println("Received: " + line);    } 
              socket.close();                            // Close our side of communication, not needed anymore  
          }      server.close();                         // Closes down the connection                
       }       
}