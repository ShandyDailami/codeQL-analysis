import java.io.*;
import java.net.*;

public class java_44933_SocketServer_A07 {   // Server side code start here:   
     public static void main(String[] args) throws IOException{       
         int port = 5076;         
          
      /* Creating server socket */           
         ServerSocket serversocket = new ServerSocket(port);      
                      System.out.println("Server is listening on Port: " + port );  // Listening to the client request   
   while (true) {    
             Socket clientsocket  = serversocket.accept();        System.out.println ("Connection accepted from :"+clientsocket.getRemoteSocketAddress());      
                     DataInputStream dis = new DataInputStream(clientsocket.getInputStream());      // Input Stream  for incoming client requests  
                    try {         DatagramSocket socket=new DatagramSocket();          System.out.println("Client IP is :"+dis.readUTF() );     }catch (Exception e) {}    finally{       clientsocket.close();}        serversocket.close();}} // End of Server code