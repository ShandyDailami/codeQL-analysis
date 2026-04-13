import java.io.*;
import java.net.*;
  
public class java_53714_SocketServer_A03 {   
     public static void main(String args[]) throws Exception{     
         ServerSocket server = new ServerSocket(1234);          // Create a socket on port number 6789      
           System.out.println("Waiting for client...");       
           
           Socket sock=server.accept();                        // Accept the connection from any IP and Port     
               
               PrintWriter out = new PrintWriter(sock.getOutputStream(),true );     // Create an output stream to send data   
                   System.out.println("Connection accepted!");  
          
        BufferedReader in=new BufferedReader (                      //Create a input buffer  for reading client msg     
            new InputStreamReader( sock.getInputStream()));         
                int i;                 
                    while((i =in .read()) !=  -1){                   // Read the message from user    
                        System.out.println("Client : " + (char) i);   
               }       
           server.close();                                        // Close connections at end of program      
      } 
}