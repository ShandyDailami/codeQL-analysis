import java.net.*;
import java.io.*;

public class java_52832_SocketServer_A01 {  // define the server-side program here
    public static void main(String args[]) throws Exception{  
        ServerSocket welcomeSocket = new ServerSocket (8189);       // set up a socket at port number 4056 and listen on it. wait for connections to come in from clients . The server will keep listening until no longer needed by the client, then gracefully terminates when an error occurs during this process
        while(true) {          /// Infinite loop so that we can accept multiple concurrent user requests  // start of your code here...    System.out.println ("Waiting for connection on port " + welcomeSocket.getLocalPort()+"...");   Socket connection = welcomeSocket.accept ( );
        try{                    PrintWriter out = new PrintWriter(connection.getOutputStream(), true) ;  // Get an output stream to send messages back to the client and a buffered reader for incoming data from clients .    BufferedReader inStream=new BufferedReader(new InputStreamReader( connection.getInputStream() ));
        String inputLine; System.out.println ("Connection established with " + connection.getRemoteSocketAddress());  try {   while ((inputLine = inStream.readLine()) != null)       // Infinite loop so that we can respond to multiple concurrent client requests until a specific message is received or the program has been stopped
        if ( inputLine .equals ("QUIT")){    System.out.println("Connection closed by Client"); break; }  else {     out.println( "Server: You sent me : '" +inputLine+ "' "); }} catch (IOException e) {} // If an exception occurs, we just close the connection and continue with next client request
        finally{connection.close();}   System.out.println ("Connection closed");  }}};