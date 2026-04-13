import java.io.*;
import java.net.*;

public class java_46694_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{        
        // Create server socket at port number = 9001          
        ServerSocket welcomeSocket = new ServerSocket(6789);            
      
        while (true){              
            System.out.println("Waiting for client...");                    
                  
            Socket connectionSocket  = welcomeSocket.accept();              // Accept a request from the clients                   
                        
            PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);      
            
           BufferedReader in = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));  
                           
      System.out.println("Connection established with client.");                
                      
          String message;  // Declare a string variable to hold incoming data    
                  
        while ((message=in.readLine()) != null){           
             if (message ==null) break ;                   
                  else {                     System.out.println("Received : " + message);   }              
         }}    catch(IOException e ){                // Catch IOException to handle exceptions                  
           e.printStackTrace();}}  finally{}     try {}      while (true){}          if () break;             else {}}}