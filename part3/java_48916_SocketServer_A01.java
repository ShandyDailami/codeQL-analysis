import java.io.*;
import java.net.*;
    
public class java_48916_SocketServer_A01 {   
       public static void main(String args[]) throws Exception{       
          ServerSocket server = new ServerSocket(12345);         //Step a: Creating the socket using port 12345  
           System.out.println("Wait for client on Port "+server.getLocalPort());    
            while (true) {      
               Socket sock = server.accept();    // Step b and c, Wait till a Client connects to the Server        
               
                          PrintWriter out =  new PrintWriter(sock.getOutputStream(), true);         
                        BufferedReader in =new BufferedReader(       	    		  	   	 	//Step e: Receiving message from client (read)    // Step f, Removing Comment 									      			          							           	     	        )                System.out.println("Connected to Client");                      out .println ("Message received by the Server ");
               String response= in.readLine();                    if ((response==null))                 {System.err.println( "Received no data from client" );sock.close();} else                  sock.close ();    } // Step a: Close connection 
           server.close ();    
       }}