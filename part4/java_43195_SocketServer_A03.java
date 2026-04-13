import java.io.*;
import java.net.*;

public class java_43195_SocketServer_A03 {
    public static void main(String[] args) throws IOException{  
        ServerSocket welcome = new ServerSocket(9876);      // Create a server socket to listen on port 12345      
        
        while (true){     // Forever loop until client dies. Just like webserver, keep running forever for debuging purpose   
            Socket connectionToClient = welcome.accept();   /* Accept incoming TCP connections */            
                
                System.out.println("Accepted new connection from " +connectionToClient);      
        
           //Create a thread to handle this client at same time, otherwise if the server goes down all clients will be gone 
            Thread t = new Thread(new ClientHandler(connectionToClient));     /* Create and start handling of each connected socket */  
              System.out.println("Started Handling for "+ connectionToClient);       //Saying that thread has started to handle the client   
              
             try {  if (t != null) t.start(); } catch(Exception e){ /* Catch and print any exceptions */                 console log ("Error while starting Thread",e );   };         
         }}    
      public static void main() {} //Preventing compiler from complaining about calling a method with the name "main"   
}  private class ClientHandler implements Runnable { /* A thread for handling each client */            
           Socket s;            Device d= null ;        PrintWriter out =null;         BufferedReader in =null;      boolean DoneReading=false, donewriting=  false     //Define a new variable type    socket the server is currently connected to.       void set(Socket s) {  this .s =  (socket);   InetAddress IP  =this         
          `