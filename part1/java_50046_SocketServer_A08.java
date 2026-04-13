import java.io.*;
import java.net.*;
public class java_50046_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket();       // Create a server socket at port 12345     
        System.out.println("Waiting for client connection...");    
         
        Socket sock=server.accept();                  // Accept the incoming request   
          
        PrintWriter out =  new PrintWriter(sock.getOutputStream(), true);  
            
       /* This line is responsible to handle A08_IntegrityFailure related operations */ 
          try {             
            BufferedReader in =new BufferedReader (                       // Receive a string from client   
                new InputStreamReader(sock.getInputStream()));                 
                  
               String command;                      // Read the received message  
             while ((command=in.readLine()) != null) {     /* Check if there're any more lines to be read */ 
                 System.out.println("Received: " + command);    // Print out what we got from client     
                  }                             
          catch(Exception e){              
            e.printStackTrace();              // Catch exception and print stack trace if present    
             sock.close();                     /* If any issue occurred while reading, close the socket */ 
         return;   
        }}           finally{                    /* This block is executed after try/catch Block to clean up resources such as Streams & Socket connections*/             
          out.close();                        // Close PrintWriter for sending purpose    
            sock.close();                       // And close the socket connection   } 
             System.out.println("Connection closed");      /* After execution of main, print a message */    }}