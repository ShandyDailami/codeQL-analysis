import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_49776_SocketServer_A03 { 
    private static final int PORT = 49876; // This can be any unused port number (0-65535)    
      
    public static void main(String[] args){         
        ServerSocket server = null;        
          
        try{                    
            System.out.println("Server started");            
               
              /* Create a new thread for handling every client connection */ 
              ExecutorService executor =  Executors.newCachedThreadPool();    // Use Cached Thread Pool         
  
               server = new ServerSocket(PORT);        
                 System.out.println("Waiting for incoming connections... ");            
                  while (true) {                    
                      Socket socket = null;          
                       try{                          
                          socket  =server .accept();       // Accept client connection                  
                        /* Create a new thread to handle communication with the client */ 
                         executor.execute(new ClientHandler(socket));   
                              }             catch (IOException ex){                 System.out.println("Error accepting " +ex);}                    
                  }}              finally {server.close();}}            // Ensures that server gets closed even if an exception is thrown                      try/finally block       for closing the ServerSocket      });   */         }     catch (IOException ex){             System.out.println("Error creating " +ex);}}}