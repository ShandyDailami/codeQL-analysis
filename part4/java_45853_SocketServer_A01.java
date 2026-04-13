import java.io.*;
import java.net.*;
  
public class java_45853_SocketServer_A01 {    
    public static void main(String args[]) throws Exception 
    {      
        ServerSocket server = new ServerSocket(1234); // Create a socket on port 1234        
            
        while (true){                        
            Socket sock=server.accept();          
               
            System.out.println("Accepted connection from: "+sock.getRemoteSocketAddress());    
              
            OutputStream out = sock.getOutputStream();   // Get an output stream and print a message to the client 
      
    String data="Hello Client, You are Connected";     
            
           DataOutputStream wr = new DataOutputStream(out);                 
                   
           wr.writeUTF(data);                
               System.out.println("Sent: " + data );    
        }         
   }  // end of while loop   
}//end class SimpleSocketServer      void main (String args[])throws Exception{}.