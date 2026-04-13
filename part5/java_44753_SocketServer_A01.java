import java.io.*;
import java.net.*;

public class java_44753_SocketServer_A01 {  
    private static final int PORT = 9876; // define the port for server to listen on     
    
    public void start() throws IOException{      
        ServerSocket socket = new ServerSocket(PORT);         
         System.out.println("Waiting connection...");          
                while (true) {              try 
            {                           
                 Socket sock=socket.accept();             // wait for a client to connect  
                  DataInputStream dis = 
                      new DataInputStream(sock.getInputStream());              
                     System.out.println("Client connected from "+dis.readUTF());   
                                                   }  catch (IOException e) {                println ("Connection closed by :" +e);              return;}   socketserver      .stop();}}                  }}