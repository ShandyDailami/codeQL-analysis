import java.io.*;
import java.net.*;

public class java_51627_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{     
        ServerSocket server = new ServerSocket(12345); // listening on port 12345         
         System.out.println("Waiting for client...");    
          
       Socket socket=server.accept();   
           
                try {            
                    BufferedReader in  =new BufferedReader (  
                            new InputStreamReader(socket.getInputStream()));             
                       String message;              
                      while ((message = in .readLine()) != null)  // reading the client input                 
                          System.out.println("Received: " + message);               
                    } catch (IOException e){                          
                         socket.close();     server.close();    return;}   });     
        }}