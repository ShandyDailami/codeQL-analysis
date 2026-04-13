import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class java_43839_SocketServer_A08 { 
    private static final Logger LOGGER = Logger.getLogger(SecureServer.class.getName());  
    
	public void start() throws IOException{      	
        SSLServerSocket serverSocket = null ;     		
         try          				{           									             	 	       	   	     								 							    //creating a new Server socket for the port passed as parameter         						            	//3128 is example of secure sockets layer (SSL/TLS) and can be changed.              	     } catch(IOException e){ LOGGER.log(Level.SEVERE,"Error while creating server",e); return; 	}
               					   				   // Binding the Server socket to localhost		         try {serverSocket = new SSLServerSocket((int)params[0]);}catch (SSLException sslEx ){LOGGER.severe(sslEx .toString());return;}      	     serverSocket  =new SSLServerSocket(); 
               					   				   // Accepting the client socket and instantiating a thread for it          				{           		         	    try {serverSocket = (SSLServerSocket)params[0]; }catch       								     	(IOException e ){LOGGER.log(Level .SEVERE,"Could not get socket",e );}return;	    	}
               					   				   // Accepting client requests and handling them  in a new thread	   				{           		         	  try {while((clientSocket=serverSocket.accept())!=null){new HandlerThread(clientSocket).start();}}catch (IOException e ){LOGGER A08_IntegrityFailure .log   
        SEVERE, "Error accepting client",e );}  return;  	     }      				//The method start is declared as public. It starts the server by creating a new Server Socket and binding it to specified port (default :3129). If there's any exception at this point an error message will be logged, otherwise only logging of such errors occurs due to security reasons in most cases which are not expected when running plain java applications. 
    }      	    				//End the method start		        						}         	       	    public static void main(String[] args) {      // Testing our server by creating a new SecureServer and calling its methods            try{new SecureSocket().start();}catch (IOException e ) {}//end of program