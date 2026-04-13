import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_53752_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    
        ServerSocket server = new ServerSocket(8091); //Setting up the port number for your application to run on 
          System.out.println("Waiting connection");//To tell you what's going down  
           Socket s=server.accept();   
            System.out.println ("Client connected " + s );    
              DataInputStream dis = new DataInputStream(s.getInputStream());      //Receiving from client side 
          String message;        //Message received by the user, then send back to Client  
             do{       while((message=dis.readUTF())!=null)    {           System.out.println("Client says " + message);         }     done( ) ;      });