import java.io.*;  // Import BufferedReader, InputStreamReader & PrintWriter classes
import java.net.*;   // For ServerSocket class java_49301_SocketServer_A03 class SocketServer {    
      public static void main(String args[]) throws Exception{      
            int port = 9876;       
              ServerSocket welcome = new ServerSocket (port);        
                System.out.println ("Waiting for connection on port " + port );   // Create a socket to receive client messages     while listening at the same address and ports 0   12345      if you do not need something like this, then use ->  new ServerSocket(port), but don't bind it.
                Socket connection = welcome.accept();         System.out.println("Just connected to " +connection.getRemoteSocketAddress());   // Accept a client socket  and handle the communication with that Client by creating an InputStreamReader & Buffered reader    while reading data from or sending on bytes at once
                DataOutputStream out = new DataOutputStream( connection.getOutputStream() );      PrintWriter writer =  new     PrintWriter (connection.getOutputStream(), true);        System.out .println ("Connection established");         // Send a request to the client  Socket    and show an incoming message back   from that Client
                BufferedReader in =new BufferedReader(                                                      new InputStreamReader      ( connection.getInputStream() ) );     String          inputLine;              while ((inputline=in .readline())!=null){         System.out           ("Server: " + inputline);        }               // Close the connections   
                welcome.close();             writer.close();connection.close();      in  .close ( ) ;   }}