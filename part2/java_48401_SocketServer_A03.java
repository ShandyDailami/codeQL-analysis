import java.net.*;
import java.io.*;

public class java_48401_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    	        
	        ServerSocket server = new ServerSocket(2019);         		     	     	 	   			       					 				      							           // Create a socket for incoming connection. (Port 2018 is just an example, you can use any port number.)  								    Socket sock =  null;    	        
	        try{             						             System.out.println("Waiting Connection");     	    while(true){	sock = server.accept();       			                    new ClientHandler(sock); } 						} finally { if (server !=null) server.close();}   // Always close the socket here instead of in accept() loop
	        System.out.println("Server Stopped.");    	        		      				         	 	   						                    							          			    Socket socketserver = new ServerSocket(1234); 								      }                 						}                 }, "utf-8"));   // Send a message to client using specified socket and charset