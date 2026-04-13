import java.io.*;
import java.net.*;

public class java_44676_SocketServer_A03 {
    private static final int PORT = 8091; //define your port number here as per requirement (Must be unique to a system and not in use by any other program)  
    
  public static void main(String[] args){        
      try{            
          ServerSocket server = new ServerSocket();          
                
          System.out.println("Server is listening on port " + PORT);                   
                 
          // Accepts client and sets up the connection                  
          Socket socketConnection =  server.accept(); 
                     
          PrintWriter out  = new PrintWriter(socketConnection.getOutputStream(), true);  
          
          BufferedReader in =new BufferedReader (
            new InputStreamReader(socketConnection.getInputStream()));      
                
         // Reading client's input and sending back to the server                 
             String userInput; 
              while ((userInput=in.readLine()) != null){  
                System.out.println("Client says :" + userInput);   
                   out.println( "Server respondes: Hello, Client!" );        
           }    
                  socketConnection.close();                     
      }catch (IOException e) {e.printStackTrace();}  //handling exceptions  
       System.out.println("Client disconnected");             
    }       
            
}