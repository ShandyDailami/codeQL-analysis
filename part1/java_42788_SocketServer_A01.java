import java.io.*;
import java.net.*;

public class java_42788_SocketServer_A01 {  
    public static void main(String args[]) throws Exception  {         
        ServerSocket welcomeSocket = new ServerSocket(12345);          
        
        while (true){              
            Socket connectionSocket  = welcomeSocket.accept();                  
            
			// Check if the client can access server socket or not by checking for a 'null' value in buffer array 
	        try {               
	            BufferedReader input = new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));   
			        PrintWriter output= new PrintWriter(connectionSocket.getOutputStream(), true);   // ensure that it is always connected and reliable      		            				    					 	    });                  } catch(IOException e) { System.out.println("Error in reading from/writing to socket.");}              	}                  
	        finally{                 connectionSocket = null;}}}            try      final ConnectionPool cp  = new   PoolManager().getConnection();    if (cp==null){System .     out. println ("Could not make a pooled client"); } else {  output..println("Client Connects Successfully ");}