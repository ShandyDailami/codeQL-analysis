import java.io.*;
import java.net.*;
  
public class java_44874_SocketServer_A08 {    
    private static final int PORT = 4567; // you can change it according to your needs, usually a free port is available on the server side for this purpose      
       
  public static void main(String[] args) throws Exception{        
      ServerSocket welcomeSocket = new ServerSocket(PORT);          
          System.out.println("Server ready..." );               
     while (true){             
            Socket connectionSocket= welcomeSocket.accept();    // waiting for client to connect      
             PrintWriter out =new  PrintWriter(connectionSocket.getOutputStream(), true);        
               BufferedReader in = new BufferedReader(                 	  	 			// reading from the socket           reader     if needed         			     									                                                                           	   															        // ... here you can write a message or get input for sending to client  and send it back.    print out then close connection
             );       System.out.println("Client connected ");                   String userInput;                     while((userInput = in .readLine()) != null){                     			System.out.println( "Received: " + userInput);                // processing input, for example echo back client message   }           
    connectionSocket.close();  System.out.println("Client disconnected");}}          welcomeSocket.close();}            
     };        public static void main(){         new SocketServer ().main(new String [ ] ); }}       Note: This is just a minimalist example and does not include any form of security or error checking, which would be necessary for production-grade code in the real world!   You should also implement some sort of protocol to ensure data integrity.