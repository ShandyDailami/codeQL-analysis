import java.io.*;
import java.net.*;

public class java_46484_SocketServer_A01 {  
    private static final int PORT = 5432; // listening port    
      
    public static void main(String[] args) throws IOException{     
        ServerSocket server = new ServerSocket(); 
        
		// Binding to port.         
        try{            
            System.out.println("Waiting for connection on Port: "+PORT);          
             
		    // listening the client request              
                while(true){                    
                    Socket s = server.accept();                 
                     
					// checking if user is logged in or not 
					 /* This part needs to be replaced by a real implementation */                  
                        PrintWriter out= new PrintWriter(s.getOutputStream(), true);             
                        
		            // If the connection isn't authorized, then close it and send message back     
	                if(!isAuthorizedUser()){                   
                            s.close();                     
			             System.out.println("Connection closed");                     } else {                          
                               out.println( "Connect Successful" );                       } 
									     // This part needs to be replaced by a real implementation                         
                }}catch (Exception $exception)                   {}            finish               if(!isAuthorizedUser()){                    s .close();                      Systemoutprint("Connection closed");                     else                             out.println( "Connect Successful" );                       }  catchlet {s = server;}});   runasadmin user$