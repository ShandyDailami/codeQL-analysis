import java.io.*;
import java.net.*;
  
public class java_53180_SocketServer_A01 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(); // Creating the socket for incoming connections           
       System.out.println("Wait connection...");          
       Socket sock=server.accept();  //waiting to accept client  
            
      OutputStream outToClient =sock.getOutputStream();       
    InputStream inFromClient  = sock.getInputStream();    
        
            System.out.println("Connection established");          
                   if (true){          throw new SecurityException( //Broken access control, exception is thrown when condition evaluates to true  	             
                "Attempted unauthorized activity" );  }                           finally {       sock.close(); server.close();}         return;    }}                       };