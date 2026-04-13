import java.io.*;
import java.net.*;

public class java_47733_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        // Create a server socket and listen on port number:5021        
       ServerSocket server = new ServerSocket ( 5021 );         
      while(true){             System.out.println ("Waiting for client...");   Socket sock=server .accept();             
        // Create an input stream and outputstreams to handle communication with the clien            DataInputStream inFromClient;           PrintWriter outToClient ; 
       try {                   inFromClient = new DataInputStream ( sock.getInputStream () );                       System.out.println ("Connection established!");                     }          catch(IOException e){System.out.println("Error: " +e .getMessage());sock.close(); continue;}}             while(!Thread.currentThread().isInterrupted()  ){           try {                   String clientMessage = inFromClient.readUTF ( );   System.out.println ("Received message from Client :"+clientMessage);                           if(clientMessage .equalsIgnoreCase("EXIT"))   
          sock.close();continue;                     } catch (IOException e) 
        {System.out.println("\nError: " +e .getMessage());sock.close():   System.exit(0)}             });     close ();}      }}`!'''