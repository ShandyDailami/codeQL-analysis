import java.io.*;
import java.net.*;

public class java_43014_SocketServer_A07 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8102); // Listening on port 8102 for connections from clients (you can adjust the ports as needed).  
        
        while(!server.isClosed()){            
            Socket client_socket  = server.accept();     
                     
            PrintWriter writer = new PrintWriter(client_socket.getOutputStream(), true);  // Creates a stream for writing to socket's output (channel).  
                       
           BufferedReader reader=new BufferedReader(new InputStreamReader( client_socket.getInputStream()));      	    	     	   
            		     	 				   			       						        					                  	       							                         .  //Creates a stream for reading from socket's input (channel).  								                   	.           
                                                                           } catch Exception e { System.out.println("Exception occurred: " +e); client_socket.close();} server.close();}}    finally{}    		     	      	   									 			       	 	        .                                        }} //main method ends here, it's the entry point of your program