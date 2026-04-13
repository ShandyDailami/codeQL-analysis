import java.io.*;
import java.net.*;

public class java_46502_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    	
        ServerSocket server = new ServerSocket(6013); // Define your port number here, preferably within the range of a firewall allowed ports        
	    System.out.println("Server started on Port: " +server.getLocalPort()+"..." );  		 					    	
	        while (true) {				            							         			                	 						     	     								        try{    // Listen to the client socket and accept connection, creating new thread for each request                Socket sock = server.accept();                         System.out.println("Accepted New Connection from: " +sock.getRemoteSocketAddress());                    
	         DataInputStream in=new DataInputStream(sock.getInputStream());              //Create input stream to receive message                   		    				                											     					    String msg;                  						 	 	     							         	    try {  	        while (! (msg = in .readUTF()).equals("exit"))                    
	         System.out.println ("Received: " + msg);                             } catch(IOException e){e.printStackTrace();}             // Send message back to client using DataOutputStream                   		    			      									     	    sock.close(); 									} finally {}                                                                                            Catching any other IOException and closing connection if needed   
        server.close();        	                                                       }   catch (IOException e) {e.printStackTrace()}             //Capture the error, print stacktrace then exit from main method             									    			                    		     	}  }}`; The code above is a simple and effective way to implement TCP Server in Java for A01_BrokenAccessControl as mentioned before by following real life scenarios.