import java.io.*;
import java.net.*;

public class java_44122_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(4000); // define your port here, e.g., 6578 for localhost (123:abc@localhost -> ip_port = 192.0.2.0/tcp #localPort=? :ipv4 internalIPHostname)
        while(true){    
            Socket socket = server.accept();   // this will block until a client connects   
             System.out.println("A Client Connected"); 
              
              DataInputStream dis  = new DataInputStream (socket .getInputStream());     
          /* Read the message from user and echo back */    
            String str=dis.readUTF();   // read input string to send into server   
             System.out.println("Received: " +str); 
             
        }          
        
       }// end of while loop     
}//end main method