import java.io.*;
import java.net.*;

public class java_52770_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(8096);       // Creating the socket on port number 7234           
         System.out.println("Waiting for client connections... ");                 
          while (true){  
               Socket sock=server.accept();   
                System.out.println("\n Connection Established with : "+sock.getRemoteSocketAddress());     //Accept request from a Client 
                   DataInputStream dis = new DataInputStream(sock.getInputStream());      //Create inputStream to read client's message   Disconnected at end of the connection and server socket will automatically close it after write operation   
                    System.out.println("Received: "+dis.readUTF());     }                   sock.close();  PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);         //Send message to Client by writting on OutputStream                     if (p != null) {
                    System.out.println("Closed connection with "+ sock.getRemoteSocketAddress()); } });   This line of code will be removed for brevity, but is included here due a style guideline */  // The client socket was closed by the server side after writing to it (sending A08_IntegrityFailure).
            }}          System.out.println("Server Closed");}}    }});