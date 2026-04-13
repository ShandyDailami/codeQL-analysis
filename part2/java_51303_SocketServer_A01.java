import java.net.*;
import java.io.*;

public class java_51303_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    	      
	        ServerSocket server = new ServerSocket(4242);         //1     	   
            System.out.println("Waiting for client on port: " + Integer.toString (server .getLocalPort()));          		   
                                         while (!Thread.currentThread().isInterrupted()){  	                  			 	 	     					      				       	       								    							}                 }                          finally { server .close();}                           //3                    	    Socket client;                      ServerSocket listener=null;                        try{listener = new ServerSocket(67);client  = listner.accept ( );                             PrintWriter out = 
new PrintWriter 	(client .getOutputStream(), true) ;    BufferedReader in  = 	    	 									     			      		 bufRead = new BufferedReader           Reader             ("\n                       Incoming Message:", client         							.getInputStream())); } catch(IOException e){System.out         (e);}
}}  SocketServerEnd                                                                                      System . out                                                     ()=;//2     EOF                    while((input  == -1)); //4                   finally {if            (!socket    .isClosed()) socket         	.close(); }                            if(listener      !=  null) listener.                close()}