import java.io.*;
import java.net.*;

public class java_44171_SocketServer_A03 {  // Start of Class Definition here  
    public static void main(String[] args) throws IOException{         
        ServerSocket server = new ServerSocket(8125);          
         System.out.println("Waiting for connection on port " + 8125 +"..." );     
 
     //accepts incoming client connections  
       Socket sock=server.accept();   
         
        try {              
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);          
             System.out.println("Connected to the Client");        
                     
              } catch (IOException e) {                   //handling any I/O related exceptions   for client communication                          throw               
                       sock.close();                     println ("Error Occurred: "+e );  return;     };    });                  try{             System.out .println("Closing the connection");sock.close ();}                    catch(IOException e){System. out .printing("\ Error occured : ", +E) }
           // end of main method here   }}            End Class definition  and rest are examples for various tasks you can use this as a basis to implement additional functionality in your server using the same principles used above}}