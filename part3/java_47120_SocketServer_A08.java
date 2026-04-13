import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47120_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(6013); // Listening port number     
       System.out.println("Waiting for client connection..."); 
        
           while (true){             
               Socket socket=server.accept();                 
                try {                   
                   PrintWriter out =  new PrintWriter  
                      (socket.getOutputStream(), true);    // Create an output stream from the input/output streams of this pair    
                         System.out.println("Client Connected!");         
                          String clientMessage;  int dataLength ;            
                           do {                             
                               BufferedReader in = new BufferedReader(new InputStreamReader   (socket.getInputStream()));                 
                                  clientMessage=in .readLine();            // Read a line of text from the input stream               
                                 System.out.println("Received: " +clientMessage); 
                                dataLength=  socket.getInputStream().available();    
                               if(dataLength == 0){    break; }               else{ continue;}         
                              }while (true) ;   // End read loop for security-sensitive operations                       });             
                                   out .println("Server: Hello Client, message length is "+ dataLength);      // Send response to client                     System.out.println ("Sent back :" +clientMessage );  break;             }catch (Exception e){System.err.println(e.getMessage()); socket.close();continue;}          
                };                 catch (IOException ex) {ex.printStackTrace();}    });                  server.close();      }}