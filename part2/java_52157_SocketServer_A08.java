import java.io.*;
import java.net.*;

public class java_52157_SocketServer_A08 {  
    private static final int PORT = 12345; // Define the port number here to be used in all places of this code where 'PORT' is written (e.g., `new Socket(...).connect()`, etc.) 
    
    public java_52157_SocketServer_A08() {   }       /* constructor */       
          
    private void startListeningForClients () {          // Start the server listening for clients        
            try{            
                ServerSocket welcomeSocket = new ServerSocket(PORT);     
                       while (true)  {                       
                            Socket connectionToClient =  welcomeSocket.accept();   /* accepts an incoming request from a client */   
                           DataInputStream inFromClient  =           null;          // reads user's input and stores it into the byte array      
                             try{                    
                                      inFromClient = new     DataInputStream(connectionToClient .getInputStream());     
                                     String datafromclient=inFromClient.readUTF();  /* Read a string from client */  	                 		                  									                                                                                 } catch (IOException e) {    // Catch and handle exceptions if something goes wrong        System.out.println ("Exception     caught when trying to listen on port " + PORT  + ". Terminating...");               
                                                try{connectionToClient .close();}catch(Exception ee){}}                  finally{} } catch (IOException e) {  // Catch and handle exceptions if something goes wrong      System.out.println ("Server exception caught, shutting down");   ShutdownHelper.shutdown(welcomeSocket);}}}         
     public static void main(String [] args ){            /*Main Method*/    new SecureSocketServer().startListeningForClients(); }        // Main method where execution begins           private class  helperThread {      Runtime.getRuntime ().addShutdownHook   ((java .lang ...) > () -> ShutdownHelper.shutdown(welcome socket));}}