import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_50538_SocketServer_A03 {  
    public static void main(String[] args) throws Exception 
    {    
        ServerSocket sock = null;        
	SSLSocket socket=null ;     
	int port = 12345;          
	String host = "localhost";            
		         
	sock  = (ServerSocket) new SSLServerSocket(port, null);   // create a server-socket using default cipher suites. 	       	   
	System.out.println("Starting Server..." );    	 					   				        			      	     
        BufferedReader in =null;          		         
	socket= (SSLSocket) sock.accept();      // accept a connection from client           						  															                
                        socket.setNeedClientAuth(true);              	                 	       	   
                                                                             					    				        			      	     
        System.out.println("Connected to: " +socket.getRemoteSocketAddress());                         		 	 
                     in = new BufferedReader (new InputStreamReader ((socket.getInputStream())));            						     															                	  	       	    sock=(SSLSocket)sock;                                                                   				         			      	     					     }                    catch (\IOException e1 ) { System.out.println ("Exception Caught!"+e); } 
        finally{if (socket != null){ socket.close();}}         if((in)!=null){try{ in .close() ;}catch(IOException e){System.out.print("Error Closing");}}}             sock = new ServerSocket(port)   // Create a server-socke