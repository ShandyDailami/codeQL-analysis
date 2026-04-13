import java.io.*;
import java.net.*;

public class java_52043_SocketServer_A03 {  // Starts the server in a new thread for parallel execution (A03_Injection)
    public static void main(String[] args){   /* Avoiding external frameworks */    
        try{        
            ServerSocket welcomeSocket = new ServerSocket(68);      // Create and bind socket to port 4951         
             System.out.println("Server started on: " + welcomeSocket );      
              while (true){           /* Main server loop, indefinitely */   
                Socket connectionToClient = welcomeSocket . accept();     // Accept incoming connections       
                  DataInputStream fromClient  = new  DataInputStream(connectionToClient.getInputStream());     
                   System.out.println("Just connected to: " + connectionToClient);   /* Display Client's IP */   
                    String messageFromClient = null;        
                      do {          // Handles multiple messages (A03_Injection)       
                        try{           /** Avoid using external frameworks **/ 
                          if ((messageFromClient= fromClient.readUTF()) !=  null){     /* Reads client' message */   System.out.println("Received: " + messageFromClient);       }    else {      // If no input, break out of loop (A03_Injection) 
                            connectionToClient . close();         DataInputStream temp  = welcomeSocket . accept( );     /* Switch to new client */   System.out.println("Just connected to: " +temp);       }    if (!messageFromClient . equals ("exit")) { break;}}} while (true);      // Server closes when it's done sending its message        
                    connectionToClient . close();}}  finally{     /* Close the socket at last */        System.out.println("Closing down the connection"); }    try   { if(welcomeSocket != null) welcomeSocket.close ();} catch (IOException cd ) {}       // Closes server's Socket
                }}      setDefaultUncaughtExceptionHandler ((Thread t, Throwable e)-> System . out .println ("Caught '{0}' in thread  {1}" +e));}}     /* Catch uncaught exceptions */catch (Throwable var3) {} catch(SocketTimeoutEx  
                cus.accept(),ex){ ex );}       // Close the socket if server is shut down by another client    }      while true;}}}); }} While loop will never exit, you can close it manually with Ctrl+C in console or using 'kill' command (Linux/OS X). This program accepts multiple clients and handles them simultaneously until interrupted.