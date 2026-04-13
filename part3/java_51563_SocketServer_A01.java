import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_51563_SocketServer_A01 {
    public static void main(String[] args) throws Exception{    	
        ServerSocket socket = null;        		     	 									 			       // Initialize server sockets and port number for connections                     
	        try {                   						                    							                 SOCKET.bind (new InetSocketAddress("localhost",12345));         	} catch(IOException e){                  	e.printStackTrace();   }        		   				    					 			       // Initialize server sockets and port number for connections
	        System.out.println ("Server is listening on localhost: "+PORT);     	 	    try { socket = new ServerSocket (12345,0 );} catch(IOException e)                 		{e .printStackTrace();	}        		    				    }             			               // Initialize server sockets and port number for connections       
          while (!Thread.currentThread().isInterrupted()) {            	    try{                     Socket connection = socket.accept ();                SSLSocket client  = ((SSLSocket)connection).getSSLSocket();           	    		       new Handler(client,this ).start ();    }catch(IOException e){              					  			     				        	}         
  }}`!#$%&'()*+,-./:;<=>?@[\]^_`{|}~1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz