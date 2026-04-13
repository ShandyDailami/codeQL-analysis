import java.io.*;
import java.net.*;
    
public class java_44885_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket server = new ServerSocket(80); // create a socket at port no:80 (http).        
            
       while(true){                   
           Socket s=server.accept();     /// accept client connection request, and establish the communication channel with this connected entity through 's'.       
              
          DataInputStream in=  new   DataInputStream(s.getInputStream());    // get an input stream from a socket for reading incoming data        
                 System.out.println("Client has Connected ");      /// print out that client is now waiting at the server            
           String str=in.readUTF();        ## read message sent by Client, and store it in 'str'  (use of ReadUtility for reading string)     // receive a text from TCP communication channel   .   
          System.out.println("Received Message : "+str);      /// print out the received client data            
         s.close();        ## close this connection with Client through 's'          
       }           
  }               
}