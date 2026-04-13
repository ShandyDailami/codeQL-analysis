import javax.net.ssl.*;
import java.io.*;
import java.util.logging.*;
import javax.net.ssl.SSLServerSocket;
public class java_51308_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SecureEchoServer.class.getName());
    
        public void start() throws IOException, SSLException{        	  
            SSLServerSocket serverSocket =  null;  //SSL Server Socket          
			int port= 8095 ;            	// Port number to bind the socket             	   			      	     	 									   								     	       							                                    						     (you should change this as per requirement)        int clientcount=1  	        
            try {                       
                serverSocket =(SSLServerSocket ) new SSLServerSocket(port);                 //Create a listener to accept incoming connections.          		             			      	     	 									   								     	       							  (you should change this as per requirement)        LOGGER.info("Secure Echo Server has started on port " + Integer.toString(serverSocket.getPort())+".");
            } catch (IOException e){                   //Catch IOExceptions if caught, then log the error and quit            	      	     	 									   								     	       							 			        		     ((you should change this as per requirement)          LOGGER.log(Level.SEVERE,"I/O Error Occurred",e);System .exit (1 );
            }       
           while(clientcount>0){            	      	     	 									   								     	       							  try{               //Accepting client connection request             		         	   			         ((you should change this as per requirement)                       Socket socket =serverSocket.accept();                   Handler thread= new EchoHandler (socket);                  Thread t=new Thread(thread );t .start ( ) ; }catch (IOException e){ LOGGER.log(Level.SEVERE, "I/O Error",e)}                
           	}       	       	      	     	 									   								     	       							  serverSocket.close();}                     //Closing the SSL Server socket when done               catch block is used for handling exception }                   public static void main (String[] args){                  try {                           ((you should change this as per requirement)                                  new SecureEchoServer().start()) ;                   
            }}catch(SSLException e ){ LOGGER.log (Level.SEVERE, "Failed to establish SSL",e)} catch (IOException ex){  //Catching general I/O exception and logging the error }    finally { System .exit (0 );}}}));     try{} Catch block is used for handling exceptions