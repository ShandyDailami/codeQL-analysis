import java.io.*;
import java.net.*;

public class java_48508_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(6013); // Port number chosen by you     
         System.out.println("Waiting for client on port " +server.getLocalPort()+"..."); 
          while (true){   
              Socket socket= server.accept();    
               System.out.println(socket.getRemoteSocketAddress()+ 
                   " has connected");   //Identify each new connection with the client's IP address and port number     
                DataInputStream dis =new  DataInputStream (socket .getInputStream());   
                  String message=dis.readUTF();     System.out.println("Client says: \"" +message+"\"") ;         Thread thread=  new MessageThread( socket , Dispatcher, "client");        //Create a separate class to handle the client's request   }  server .close ();   
            }}`