import java.io.*;
import java.net.*;

public class java_50976_SocketServer_A01 {
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(2018); // listen to port no=2017    
          System.out.println("Waiting for client on " +  
                      server.getLocalSocketAddress().toString()); 
             while (true){             
                 Socket socketConnection =  server .accept();   
                  System.out.println(socketConnection.getRemoteSocketAddress()+" Has connected");      
                     DataInputStream dis = new     DataInputStream(socketConnection.getInputStream());     
                      String message=dis.readUTF();   // read a string from client  Message in UTF-8 encoding    byte[] bytes  =new          ByteArrayOutputStream().toByteArray ();           System.out .println("Client :" +message );            socketConnection.close();         }    
        server.close();     
       }}`