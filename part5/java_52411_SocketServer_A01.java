import java.net.*;
import java.io.*;
public class java_52411_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket server = new ServerSocket(2001); //port to listen on    
      while (true){             
          Socket s=server.accept();        
           System.out.println("New client connected");              
            DataInputStream dis=  new DataInputStream(s.getInputStream());            
                String message =dis.readUTF();   
                    if(!message.equalsIgnoreCase("exit")){              //if user does not want to exit, then write this           System.out.println ("Message Received:"+message);   }  else {        break;}}         finally      {s.close();}          }}                 };