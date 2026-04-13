'
import java.io.*;
import java.net.*;
  
public class java_43175_SocketServer_A03 {    
    public static void main(String args[]) throws IOException, InterruptedException{     	        		         	       	 	   	      }       private ServerSocket server; int clientCount = 0 ;  final int PORT= 9876;        try           	{          			   while (true){               Socket sock = this.server .accept();                new Thread(()-> handleClient(sock)).start();    	       	         }     
    }}                 private void handleClient(Socket client) throws IOException, InterruptedException{         				       BufferedReader in = 		 	 	   			   new BufferedReader (new InputStreamReader                      (client.getInputStream()));                          PrintWriter out =                             					               new PrintWriter                   	        	(client.getOutputStream(), true);                       String msg;                  while ((msg  =                                 
in .readLine()) != null){               		     if( "exit".equalsIgnoreCase(msg)) {   System.out.println("Client disconnected"); break;} else{ 					            out.println("\nYou said: \""+msg+"\" - I have read it.");}} }