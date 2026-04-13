import java.io.*; // Input/Output Streams and their related classes 
import java.net.*; // Networking Classes (for ServerSocket)  
    
public class java_51995_SocketServer_A01 {     
    public static void main(String[] args){         
        try{             
            ServerSocket server = new ServerSocket(42069);            
         System.out.println("Broken Access Control Security Sever Started..." ); 
              
           while (true)   {                 
                //Accepting the incoming client request     
                 Socket socket  =server .accept();             
                  
                    new BrokenAccessThread(socket).start();          }    
        }}catch(IOException e){             System.out.println("Error in Connection Handling... ");    e.printStackTrace();}       finally{         if ( server != null ) {   try {server .close() ;  } catch ( IOException ioe) {} }}}     `enter code here `