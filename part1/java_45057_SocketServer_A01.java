import java.io.*;
import java.net.*;

public class java_45057_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{ 
        ServerSocket server = new ServerSocket(4243); // port number is arbitrary, change as needed            
       System.out.println("Waiting for client...");        
    
      while (true){         
           Socket socket = server.accept();   
            PrintWriter out = 
              new PrintWriter(socket.getOutputStream(), true);                  
               String inputLine;  
                BufferedReader in = 
                 new BufferedReader(new InputStreamReader(socket.getInputStream()));                 
             while ((inputLine = in.readLine()) != null) {                     
                    System.out.println("Received client: " + inputLine);              // received message from the user          
                     out.println ("Server : Hello Client, nice to meet you!");     // echo back        
             } 
               socket.close();  
      }}         
}