import java.io.*;
import java.net.*;

public class java_45722_SocketServer_A07 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(4001); // Listening port, change this as per requirement 
        
        while (true){           
             Socket sock=server.accept();     
              System.out.println("Connected");    
              
              DataInputStream in= 
                  new DataInputStream(sock.getInputStream());    // Input Stream  
                     
                 OutputStream out = sock.getOutputStream();  //Output stream to send data back for client               
                         
             String message;                  
                     do {                        
                        try{                           
                           if ((message=in .readUTF())!=null){    
                             System.out.println("Received: "+message);  
                              }    else  break ;                  // If null, client closed connection        
                          } catch (IOException e) {}               // IOException Handling               
                     }while(true);                        //Infinite loop to read from input stream         
                      out .writeUTF("Success!");            // Writing back the message                
                       sock.close();                         // Close socket  and also end connection             
                  System.out.println ("Disconnected");      
               } while (true) ;                          //Ending of server loop            
        }  
    }    
}