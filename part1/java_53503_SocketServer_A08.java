import java.io.*;
import java.net.*;

public class java_53503_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        // Creating socket and server port     
        ServerSocket welcomeSocket = new ServerSocket(6789);      
         System.out.println("Wait for connection");                
          while (true){             
            Socket connectionSocket  = welcomeSocket.accept();            
               BufferedReader inFromClient=new BufferedReader(                     // Reading from client socket  
                new InputStreamReader(connectionSocket.getInputStream()));    
                  String userInput = inFromClient.readLine();        
                   System.out.println("Received: " +userInput);             
                    if (userInput==null) break;                          
                     connectionSocket.close();                             // Closing the client socket  
                      }      welcomeSocket.close();                         //Closing server port   
                       }}