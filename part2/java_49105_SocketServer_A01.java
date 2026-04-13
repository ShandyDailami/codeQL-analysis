import java.io.*;
import java.net.*;

public class java_49105_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{      //e
        ServerSocket server = new ServerSocket(6013);              //f
        
        System.out.println("Waiting for client...");              
         
       while (true){                                             //a  and b  
            Socket socketConnection =  server.accept();           //c   
            
            PrintWriter out = new PrintWriter(socketConnection.getOutputStream(), true);//e    
             
         System.out.println("New connection accepted from " + socketConnection.getRemoteSocketAddress()); 
         
        out.println("Hello Client, you are connected to server");   //b    and c      
                                                                                                  }                      while(true)                 ;                   });                                                            };     }}//e this code will not compile because of the println statement inside a loop due its unreachable part (a-c).  This is an example. The security sensitive operations in A01_BrokenAccessControl are IOExceptions which can't be caught and handled, so we use try/catch block to handle it