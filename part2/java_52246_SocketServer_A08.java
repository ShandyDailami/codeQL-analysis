import java.io.*;
import java.net.*;

public class java_52246_SocketServer_A08 {
    private static final int PORT = 5678; // arbitrary port number, should be changed in production code when necessary
    
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(); 
        
        try {
            System.out.println("Server is listening on Port: " + PORT);   // announce the port number that listener will use for communication in console logs or other application's output messages   
            
            Socket socketConnection = null;    
              while(true){  // main server loop waiting to accept client connections. This should be changed into a production environment, with exception handling and possibly threading if necessary  
                  try{       
                      System.out.println("Wait for connection on port: " + PORT);   
                       socketConnection =server.accept();            
                        new SecuredEchoServer(socketConnection).start();      // spawn a server process to handle communication  with the client    
                    } catch (IOException e) {   /* if exception thrown, then close connection and terminate */          System.out.println("Exception occurend while connecting or processing" +e);             socketConnection.close();         break;           }}      finally{server.close();}}  // ensure the server is closed no matter what happens
                 }     catch (IOException e) {    /* if exception thrown, then log it */              System.out.println("Server failed to bind port: " + PORT);   e.printStackTrace();}}}        `