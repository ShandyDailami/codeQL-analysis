import java.io.*;  // Input/Output Streams, Socket Classes & Exceptions  
import java.net.*;     // ServerSocket Class and others exceptions   

public class java_46852_SocketServer_A08 {      /* Start of the server */        
       public static void main(String[] args) throws Exception{         
             int port = 6012;          
            try (ServerSocket server = new ServerSocket(port))  {              // Create a socket on given port.              
                  System.out.println("Waiting for client connection...");         // Wait until someone connects here     
                 Socket incoming = server.accept();                         /* When connected, return the Connection object */           
             }          
       }        // End of main  method   
}          // end class MyServer