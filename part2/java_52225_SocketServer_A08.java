import java.io.*;
import java.net.*;

public class java_52225_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(1234); //Create a Server socket and bind it to port no: 8096, this will listen at that number.     
         System.out.println("Server Started...");  
         
           while (true) {   
               Socket s = server.accept();    
                System.out.println("\nConnection Established with " +s.getRemoteSocketAddress());  //print what is connected from which IP address and port number     
                   Handler h= new Handler(s);  
                    Thread t=  new Thread(h);   
                 
               t.start();    
            }        
        }      
}         `