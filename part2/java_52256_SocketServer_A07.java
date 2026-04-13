import java.io.*;
import java.net.*;

public class java_52256_SocketServer_A07 {
    public static final String CRLF = "\r\n"; // Can be replaced with '\n'. The server will send data line by line in this format, not byte-by-byte as it usually does for HTTP/1.* clients (requires some work around to handle multi part requests) 
    
    private static String decrypt(String s){ return "AES-" + new StringBuilder(s).reverse().toString(); } // A simple encryption. Replace with your own method of securely storing and retrieving password data, as the given example is not suitable for that purpose (it'd be better to use a hash function or similar) 
    
    public static void main(String[] args){  
        try{            
            ServerSocket server = new ServerSocket();          
              System.out.println("Waiting on port " + Integer.toString(server.getLocalPort()));      // Waits for a client to connect, then will print the connected IP and accepted socket details 
              
                  Socket connectionToClient  = server.accept();        
                  
                PrintWriter out = new PrintWriter (connectionToClient .getOutputStream(), true);      
                
              BufferedReader in =new BufferedReader(  
                           new InputStreamReader(connectionToClient.getInputStream()) );              
                    
                  String clientMessage, serverResponse;  // Define two strings to hold the messages received and sent by a user from browser   
                          for (; ; ) {                       # Create an infinite loop so that our program doesn't end immediately (this could be modified if you wish)                  
                      try{  
                        System.out.println("\n*** Waiting message ***\n");  // This will display the input received by browser from webserver, this is for demonstration only                   
                             clientMessage = in .readLine();       # Read a line of text sent to server              system out          println("Hello "+decrypt(clientmessage));   It's not good practice or secure way as it allows anyone read the username/password. Use AES-encrypted information transfer instead!
                        }catch (IOException e){                      System .out .println (" Error 406 -" +e); break;                   # Catch and handle any IOException if one has occurred              }}        // Close down everything, no matter what happened in the try block.   Closes connection to client    out     
                          }}}     catch (IOException e){ System.out .println (" Error 402 -" +e);}             # Catch and handle any IOException if one has occurred                                                                                             return;                   // Exit Program       }}                 ** END of PROGRAM**                });                      try { Thread t = new Thread() {}