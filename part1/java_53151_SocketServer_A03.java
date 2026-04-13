import java.io.*;
import java.net.*;  
public class java_53151_SocketServer_A03 {   
 public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(80);      // creating a socket on port number '80' which is the default for HTTP 
         System.out.println("Waiting connection from client..." );      
          Socket sock=server.accept();  		   	// accepting incoming request       	    	   	 	     									           			            						      }           while(true);                 // infinite loop until break is encountered                     	}                catch (IOException e) { System . out . println ("Exception caught " +e );}