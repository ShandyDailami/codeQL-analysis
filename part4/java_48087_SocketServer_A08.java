import java.io.*;
import java.net.*;

public class java_48087_SocketServer_A08 {
    private static final String HOST = "localhost"; // Server will listen on this address and port combination
    
   public void start() throws IOException{
        System.out.println("Starting server..."); 
        
       try (ServerSocket socket =  new ServerSocket(8189)) {   
           while (true) {               
              Socket connection = socket.accept();                 
               handleConnection(connection).start();      // Launch a thread for the client                     
            }       
          } catch (IOException ex){  
             System.out.println("Server exception: " +ex); 
         }          
     }   
      
 private static PrintWriter handleConnection(Socket connection) {                 
 return new PrintWriter(connection.getOutputStream(), true);                   // Returns a writer which will write to this socket output stream               
}   public static void main (String args[] ) throws IOException{         
         SecureTcpServer server =new 	SecureTcpServer();                	// Create the Server           
        try {server.start() ; }catch(IOException e){e.printStackTrace();}} // Main method begins execution here   									  															     };             		     	}			                                              	}); }}                   });}                                                                                     ); ))))) )); ((((() ((())) ()