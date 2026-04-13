import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_49020_SocketServer_A08 { 
     private static ExecutorService pool = Executors.newCachedThreadPool();    // Pool of worker threads for handling multiple clients concurrently (optional)       
     
       public static void main(String[] args){         
           SSLServerSocket serverSocket=null;            
            try {              
                SSLServerSocketFactory sslServerSocketFactory =             
                        (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();                
                  // Create a new socket on the specified port, and bind it to an InetAddress or network location  	    			  server_port=8091;                     		         	     									    Socket clienteSocket = sslServerSocketFactory .createServerSocket(server_port);             
                  //Accept Client Connection                  
                SSLSocket socketSSL =  (SSLSocket)clienteSocket.accept();              			  	            	 	    serverSocket=socketSSL; 		    	       									      	//Create a secure channel on the accepted connection and bind it to an InetAddress or network location   									socketSSL = sslServerSocketFactory .createServerSocket(server_port);
                System.out.println("New Connection Established: "+ socketSSL );	    			  		        //Establishes a new secure channel for client communication      									      printWriter=new PrintWriter (socketSSL.getOutputStream(), true);            	 	   	//Sends the request to be processed 
                BufferedReader reader = new BufferedReader(                       new InputStreamReader( socketSSL.getInputStream()));                  String userInput;         		  			     while ((userInput = reader .readLine()) != null) {                     // read from client and print   									      System.out.println("Client: " + userInput);      	            	//Sends the response to be processed 
                PrintWriter writer =  new PrintWriter(socketSSL.getOutputStream(), true );    			  	 	        String reply ="Hello Client, you connected successfully!";        		        //write in client socket   									      System . out . println (reply);      	            	//Receive the response from server
                }catch  Exception e {e.printStackTrace();}              finally{     if(serverSocket != null)   try {server_socket.close();	} catch (IOException ex){ex.printStackTrace() ;    }}          // Close Socket Connection       		      pool .shutdownNow ()	;
            }catch  (IOException e )	{e. print stack trace;}             finally{poolExit:})}          	// Exit Program      			  									                  });