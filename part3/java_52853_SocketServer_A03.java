import java.io.*;  // Input/Output Stream classes are needed by all code below    
import java.net.*;   //Socket, ServerSocket class java_52853_SocketServer_A03 used for network programming   
public class VanillaServer {       
// Main method to start the server         
 public static void main(String args[]) throws Exception{     
  int port = 4001;       // Default Port     try-catch block will catch if a non integer input provided by user, which is not required here.    ServerSocket socket = new ServerSocket(port);   System.out.println("Server started at: " + sock.getLocalSocketAddress());     
  while (true) {          Socket connectionToClient  = socket.accept();        BufferedReader inFromClient=new BufferedReader((InputStreamReader(connectionToClient.getInputStream()))); PrintWriter outToclient = new PrintWriter(connectionToClient.getOutputStream(), true);   try{            String clientMessage;             while ((clientMessage = inFromClient.readLine()) != null) {                 System.out.println("Received: " + clientMessage);                }         
  }     socket.close();      // Close the connection to any potential clients          
         if (connectionToClient !=null){                    try{                   outToclient .println ("Server Closed");                     PrintWriter[] writers = connectionToClient.getOutputStreams() ;               for(PrintWriter writer :writers ) {writer.close();}                  }catch  (Exception e) {}        
    }}   catch (IOException e){ System.out.print("Error: "+e);}}     finally{socket=null;}//This will always execute no matter what, we use it to close the socket and release any resources used by sock variable that are not closed already in other place}  }