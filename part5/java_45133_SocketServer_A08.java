import java.io.*;
import java.net.*;

public class java_45133_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        // create a server socket and wait for incoming connections on port number 'port'        
       ServerSocket welcomeSocket = new ServerSocket(6789); 
            
      while (true){         
           System.out.println("Waiting for connection from client..." );               
            Socket connectionSocket = welcomeSocket.accept();              // waiting to receive a message                 
               try{    
                 PrintWriter out=new PrintWriter(connectionSocket.getOutputStream(), true);            
                   BufferedReader in = new BufferedReader (                                          
                             new InputStreamReader(connectionSocket.getInputStream()));                    
                          String userInput;   // we declare a string to hold the input from client    
                            while ((userInput=in.readLine())!=null){    /// read line of text and wait for next message in loop                   
                                         System.out.println("Received request: " + userInput);                      
                                           if(userInput != null &&  (!"quit".equalsIgnoreCase(userInput)) ){   // quit command to close the connection                          }                              else { out.println ("Sorry, no response received for your last message");}                 }}                     catch (IOException e){ System.out.println("Error in communication: " +e); break;}}             
                           finally  {}                                                    try{welcomeSocket.close();}catch(Exception ex){}}}                       // closing the connection     }                   });   }}    public class SocketServerExample {public static void main (String[] args) throws Exception {}, import java .io,java.,importjavax..net;}