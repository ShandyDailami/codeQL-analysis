import java.io.*;
import java.net.*;

public class java_51128_SocketServer_A08 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(12345); // listen on port 12345 for client connections  
         System.out.println("Waiting For Connection.....");      
          Socket socket=null;     
           try {           
             while (true)              {              
                  socket = server.accept();       
                 OutputStream outToClient = 
                        socket.getOutputStream();     // Send to client  the message    "Thank you for connecting"  
                      DataOutputStream out = new DataOutputStream(outToClient);     
                       String thankMessage=("Thank You For Connecting");      
                         System.out.println("\nFROM CLIENT : " +thankMessage );        printBytesReversedInHexFormat (socket,server);  // Print the bytes received in hex format          }           catch(Exception e) {e.printStackTrace();}         finally{ socket.close(); server.close();}}   
                       System.out.println("\n Client Disconnected from: " +  
                     socket.getRemoteSocketAddress());     return;}}}                  // If it is a client, the program  closes down by itself (and not recommended!)        printBytesReversedInHexFormat(socket);          server.close();}}            System.out.println("\n Server Stopped."); }     
}    private static void   printBytesReversedInHexFormat(Socket socket,ServerSocket server)  { try{           // Receive data from the client and echo it back to client        DataInputStream inFromClient = new         DataInputStream (socket.getInputStream());       BufferedReader reader = 
new     BufferedReader    (      new InputStreamReader(server.accept().getInputStream()));   System.out.println("\nServer : " +reader);           String line=null;            while ((line  =                 reader .readLine()) !=  null) {        printBytesReversedInHexFormat((Socket ) socket, ( ServerSocket 
                         server));      }}}                catch(IOException e){e.printStackTrace();}   }}