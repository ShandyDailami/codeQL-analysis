import java.net.*;
import java.io.*;

public class java_52838_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    	        		      
	        ServerSocket server = new ServerSocket (45678); // open port 1234       	     	   
           System.out.println ("Waiting for client on port " +  Integer.valueOf   (server .getLocalPort ()).toString() +" ...");                 	            		      
          Socket socket = server.accept();     	       									    			    // wait and accept connection from a new Client           						 	   
           System.out.println ("Connected to " +  socket.getRemoteSocketAddress());                    	 								  							        }               public class Handler extends Thread {                                                  	        		       private Socket sock;             					    			    //socket the handler will work on                                       				     	     	// 
           @Override                      	public void run()                     	{          try{            	        BufferedReader in = new BufferedReader(new InputStreamReader (sock.getInputStream()));                    	        		       String line ;            while ((line=in .readLine()) !=  null) {                  System.out.println ("received : " +   line); }           }}