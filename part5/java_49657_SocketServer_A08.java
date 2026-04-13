import java.io.*;
import java.net.*;
    
public class java_49657_SocketServer_A08 {      
    public static void main(String[] args) throws IOException{       
         ServerSocket server = new ServerSocket(8189); // Set up a socket on port 8189 for client connections to connect with     
          while (true){           
               Socket sock = server.accept();   
                DataInputStream inFromClient = 	new   DataInputStream(sock.getInputStream());      
                  String fromClient = inFromClient .readUTF();     // Read the message sent by client 		        
                   System.out.println("Received: " +fromClient);     	 			   									            	   	       	     							                	System. out . println (“Server echoing back user input” );   if(! from Client) break; } catch(IOException e){ sock. close(); return;} 
           }}          try { server.close();}catch (Exception ex){}}     // Close the socket and log any exceptions that occur