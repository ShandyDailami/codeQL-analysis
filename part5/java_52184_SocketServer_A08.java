import java.io.*;
import java.net.*;

public class java_52184_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    	      
            ServerSocket server = new ServerSocket(8095);      // Create a socket on port 67, the same as client's request          
             while (true){                 
                    System.out.println("Waiting for Client..." );   
                   Socket sock=server.accept();  
                      PrintWriter out = new PrintWriter(sock.getOutputStream(), true);     // Get an output stream  in order to write the message on socket         
                       BufferedReader in =  new BufferedReader (new InputStreamReader(sock.getInputStream()));    // Create a reader for reading incoming data        	  			              									       while ((line = in .readLine()) != null){    		  System..println("Received from client: " + line);           }             
                      sock.close();     	     	 	   	       
           	}                   						    //Close the server when done                         Server socket is closed here, to free up system resources                    					  			         				      	                                                                         if (line != null) System..println("Closed down" + line); }}}  Exception e ) {e.printStackTrace();}