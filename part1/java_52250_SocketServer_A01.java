import java.io.*;
import java.net.*;

public class java_52250_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    	
         ServerSocket server = new ServerSocket(8765); // default port for socket programming is usually 1234/TCP, so I've used a number around it slightly high. Adjust as necessary according to your needs and requirements!   		            			  									      }    
        while (true) {      	                							          Socket sock = server.accept();                System.out::println("Accepted connection from " + sock);                          DataInputStream dis=new 	   	 	       	      DataOutputStream dos=  new DataOutputStream(sock.getOutputStream());              BufferedReader br = 
   													  	    		        				            			      new       BufferedReader (                       InputStreamReader                  ((Socket)                     Socket           )               );                        String clientMessage;                      int num;                              try { 	        } catch(){}          finally {}            if (!Thread.currentThread().isAlive()) sock .close();    server.close();}    
        System.out::println("Closed connection");      }}