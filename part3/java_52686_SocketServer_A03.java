import java.io.*;
import java.net.*;
  
public class java_52686_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(3000); // setting up the port number to listen on insecurely for incoming connections                
            
        while (true){                            
            System.out.println("Waiting Connection..." );                         
                    
            Socket socket = server.accept();                                     
                   
           new Echoer(socket).start();   // spawns a thread to handle communication with this client                      
       }                                                 
    }    
}