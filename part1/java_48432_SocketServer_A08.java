import javax.net.ssl.*;
import java.io.*;
import java.net.*;
public class java_48432_SocketServer_A08 {    
    public static void main(String[] args) throws IOException{  
        int port = 7001; // Choose an arbitrary local port         
         try {            
            ServerSocket server = new ServerSocket();             
                     System.out.println("Waiting for client on Port : " +port);               
                    Socket socket  =server.accept();   	                
                      SSLServerSocket sslsock=(SSLServerSocket)socket;     			 		          				           	   	 					   //Create an SSLSocket from the Server's accepted socket     System.out .println("Connection established");             	     	        } catch (IOException e){System. out. println ("Failed to establish connection with client on port : " +port);                 	        
                 if(server !=null) server.close();  //Don’t forget this!               					  			    try {                   Socket sock = sslsock .accept();            				        SSLSocket socket1  = (SSLSocket )sock ;           		          InputStream inFromClient= 	socket1	.getInputStream()	;    
                                                                                            BufferedReader reader =  new  BufferedReader(new                     InputStreamReader   (inFromClient));     			           //Read client's message   				        String data=reader.readLine();             System .out         	  out         ("Received :" +data+ " From Client");             
                    } catch (IOException e) {e.printStackTrace() ;} 					  		           	       	     finally{if(socket !=  null ) socket       	.close(); if     					(sslsock   ！=null){ try             sslsock .close();                    	}         			 }}catch