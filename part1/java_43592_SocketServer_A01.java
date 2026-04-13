import java.io.*;
import java.net.*;
public class java_43592_SocketServer_A01 {  
    public static void main(String[] args){    
        String clientMessage, serverResponse;     
          Socket sock = null ;       //socket that connects the clients to this socket (server)           
         try{            
              ServerSocket servSock= new ServerSocket(8090);  /*Create a server-side socket and listen on port number 'port'*/  
               while(!Thread.currentThread().isInterrupted()){    //main loop: wait for client connection           System.out.println("Waiting...") ;     sock = servSock .accept();      if(sock==null ){System.out.println ("Null socket"); continue;}  
               PrintWriter out= new PrintWriter (sock.getOutputStream(),true);    //initialize a writer to send messages across the network  System.out.println("Connected with "+ sock.getRemoteSocketAddress());     BufferedReader in =new BufferedReader(             new InputStreamReader((sock.getInputStream())));         
               clientMessage=in .readLine();   // read message from a socket           serverResponse =  (clientMessage).toUpperCase().concat("_RESPONSE");      out.println ("Server says: "+serverResponse);     } catch(IOException e){  System.out.print("Error in communication...") ;e . printStackTrace(); continue;}}      
          finally {sock.close();}    //finally block to close the socket             if (servSock != null ) servSock.close()      } catch(IOException e){System.err.println ("Exception caught on closing");   e.printStackTrace();}}}  */ This code is a basic server-side implementation that listens for connections and sends back uppercase versions of the client's messages to prevent broken access control from A01_BrokenAccessControl violation in Java Socket programming model