import java.io.*;
import java.net.*;
  
public class java_44599_SocketServer_A03 {     
    public static void main(String[] args) throws IOException{            
        ServerSocket server = new ServerSocket();     // Bind address and port for client socket        
         
       try {             
            System.out.println("Starting the sever...");              
           int conn = 0; 
    while (true){  
                Socket sock=server.accept();        /* Create a new connection to handle this */    
                 ++conn ;                   // Keep track of how many connections have been made           
                 System.out.println("Connection #" + conn);     
                          Thread t =new Echoer(sock,conn).start();   /**/         });    }           catch (IOException e){          server.close(); throw new IOException("Exception",e)}                finally {server.close()}}  // Close the socket connection            public class SocketServerExample{