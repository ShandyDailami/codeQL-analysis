import java.io.*;
import java.net.*;

public class java_43253_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{  
        ServerSocket welcomeSocket = new ServerSocket(8189);      // set the port number of server socket 
         System.out.println("Waiting for client on port: " + 8189 );           
         
             while (true){             
                 Socket connectionSocket = welcomeSocket.accept();       // waiting until a request comes in from user side  
                  System.out.println ("A new Client is connected :)" );    
                   DataOutputStream outToClient  =new    DataOutputStream(connectionSocket.getOutputStream());     
                    BufferedReader reader= new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));        //read from client      
                     String userInput;  
                      while((userInput =reader .readLine()) !=  null ){     }    System.out.println("Client says: " + userInput);      DataOutputStream outAuth  = connectionSocket.getOutputStream();  try {             if ( authenticateUser( reader) == false){           throw new Exception ("Unable to Authenticated" );        
                                                                   //if not matched, then deny the client       }            else{                     String welcomeMessage = "Welcome User";                       outAuth .writeBytes(( welcomeMessage + "\r\n").getBytes() )) ;                  connectionSocket.close();                   System.out.println("Closed Connection");}
                                                                   }} catch(Exception e){              // catching any exception that might occur in the try block     }}}}}}