import java.io.*; // Import necessary Java Libraries  
import java.net.*;// To create socket server, client and data streams   
    
public class java_47591_SocketServer_A03 {     
        public static void main(String args[]) throws Exception{             
            ServerSocket server = new ServerSocket(4001);          // Create a sever side socket            
         System.out.println("Waiting for Client on port 4001");    
  
    Socket sock =server.accept();                             // Accept client request and establish communication channel with the requested host,port                 
     
           DataInputStream in=new DataInputStream(sock.getInputStream());// Get input stream from socket for reading data sent by clients                         
        BufferedReader reader =  new BufferedReader (                      // Create a buffering character input stream 
                new InputStreamReader(sock.getInputStream()));           
    String clientInput;                                         // Declare variable to hold the received message        
     while((clientInput=reader.readLine())!=null){               // While loop until user enter something in command line         
              System.out.println("Received: "+clientInput);  
        }                  
    sock.close();                           // Close connection with client            
  }     
}