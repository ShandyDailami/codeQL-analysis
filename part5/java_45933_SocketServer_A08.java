import java.io.*;
import java.net.*;

public class java_45933_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  
        // create a server socket at port number PortNumber    
        ServerSocket welcomeSocket = new ServerSocket(PortNumber); 
        
        while (true){             
            System.out.println ("Waiting for connection... ");     
            
            Socket connectionSocket = welcomeSocket.accept();         
            System.out.println("Connected to client");    // print a message on the console      
              
                   Thread thread1= new Thread(new ClientThread (connectionSocket)); 
                   thread1 .start();   }    
        }}// close server socket      private class inherits RunntimeException          public java_45933_SocketServer_A08() {throw ne wirte your code here to catch and handle the exceptions.}}