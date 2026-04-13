import java.io.*;
import java.net.*;

public class java_52143_SocketServer_A01 {
    private static int port = 8765; // Port number to use or a free one if possible (lowest common multiple of all ports greater than your machine's UID) 
    
   public void start() throws IOException{      
        ServerSocket server = new ServerSocket(port);        
           System.out.println("Server started at port: " + Integer.toString(server.getLocalPort()));         
            Socket socket = null;            
              try {               
                 // Listen for a client connection to the server 
                   socket  = server.accept();  
                  PrintWriter outToClient =  new PrintWriter (socket.getOutputStream(), true);   
                      BufferedReader inFromClient=  new BufferedReader(new InputStreamReader(socket.getInputStream()));      
                       String fromServer;               
                          while ((fromServer = inFromClient.readLine()) != null) {                          
                               System.out.println("Received client: " + fromServer);                            // Print the received string on console 
                                 outToClient .println ("Thank you for connecting to server! Message has been sent back by Server.");     }                      catch (IOException e){          ExceptionUtilities.printStackTrace(e, null) ; continue;         }}                  finally {               if((socket !=null)) socket.close(); 
                                           server.close();      System.out.println("Server Stopped");}    return;}        public static void main (String [] args){ new VanillaTCPServer().start();}}     }`