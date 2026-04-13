import java.io.*;
import java.net.*;

public class java_46757_SocketServer_A01 {   // Defining server name 
    private static int port = 80;     // Define the outgoing ports to restrict access and authentication based on client's IP address (change as per your requirements)
                                     /* Note: The purpose of this restriction is not about blocking legitimate users, but rather preventing unauthorized persons from connecting. */ 
  
    public static void main(String[] args){        // Main method for the server program starts here
      try {                                             
         ServerSocket welcomeSocket = new ServerSocket (port);     /* Create a socket to be listening on port number provided above*/      
          System.out.println ("Server is waiting..." );  
          
            while(true)                     //Infinite loop that will keep the server running until it's manually stopped 
               {                          
                 Socket connectionSocket = welcomeSocket .accept ();    /* Accept incoming client request */      
                  System.out.println ("A new Client has connected : " +  
                                      connectionSocket );     // Print out what socket is being used for, in this case the port # 80                  
                                                            /* Create a thread that will handle I/O operations on behalf of one client at once */      
                  Thread t =new Thread( new SecureClientHandler (connectionSocket));    // Instantiate and start New ClientThread here.    
               }  
           welcomeSocket .close ();  };                          /* Close the Server Socket after all clients have disconnected*/                      System.out.println ("Server Stopped ");}) ;                                  try { Thread t = new SecureClientHandler(socket );t.start();} catch (Exception e){System.err.println("Error: "+e);}}
   }  // End of main method     /* Server class definition */       public static class SecureClientHandler implements Runnable{    private Socket socket;      public java_46757_SocketServer_A01(Socket socket) { this .socket = socket;} @Override publÌc void run() {}             if (true){ System.out.println("Exception: Not authenticated"); return ; } // Print out error message to client here */  try{ InetAddress address=InetAddress.getByName(socket_.getInetAddress().toString());    /* Check IP Address is allowed or not*/  
      if (!addressesAllowedToConnect .contains ( socket_ ) { System.out.println("Exception: Not authorized to connect"); return ; }}  try{ sock new DataOutputStream     ((SocketOutputStream) out).writeBytes( "Secure Connection" ); }catch    e){System,err   println ("Error : Exception while trying          writing the response:"+e);}} else { System.out .println (          
      //The client has disconnected and server will be notified in a new thread         if  (!socket_.isConnected()) return ; try{ sock =    socket_.....setAuthenticated(true) ); }catch          e){System,err   println ("Error: "+e);}}
      //Exception handling is also provided here for the case of errors encountered by client or server.  In such a situation it will be printed on console and further action can take place according to application's requirement (like closing connections etc). */    } /* Ending if block condition checking whether authentication has been successfull then only print welcome message otherwise show error msg*/