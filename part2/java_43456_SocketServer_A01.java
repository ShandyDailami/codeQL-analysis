import java.io.*;
import java.net.*;

public class java_43456_SocketServer_A01 {   // Class definition of Socket Server    
    public static void main(String[] args) throws IOException  {         //Main Method Starts here       
       int port = 6012;             // Define a Port number for the server to listen.                  
                                       
       while (true){                //Run forever until break condition is met     
           try{                      // Begin Try block    
               ServerSocket welcomeSocket = new ServerSocket(port);   /* Create and launch SocketServer */   
                                          Console con= System.console();  consoleName =  String .valueOf((char) (con).read());        println("Starting server on port: " + port+"\nConsole Name :-"+consoleName );               // Start Server          
                while(true){             /* Run infinite loop for accepting multiple client requests */           
                    Socket connectionToClient = welcomeSocket.accept();    // Accept Connection from Client   println("Connection accepted");  socket connected with the below name     sockname=connectionToClient;       if (sockname==null) {println ("Null is not a valid address "); continue;}     
                     PrintWriter outMsg =  new PrintWriter( connectionToClient.getOutputStream(), true);    // Get Output Stream from Client  println("Writing to :"+ sockname );     Threaded_clientthread clientThread  =new   ThreadedClientsHandler (connectionToClient,outMsg) ;     
                    outMsg .println ("Connection Established with: " +sockname);                     //Send Message back for the accepted Connection  println("Message Sent");    }catch(IOException e){print("\n"+e.getMessage()); continue;}   }}                 catch (Exception ex) {ex.printStackTrace();}}