import java.io.*;
import java.net.*;

public class java_53800_SocketServer_A08 {
    private static int port = 4567; // default Port number, change as needed
    
   public void start(int port) throws IOException{		// function to create server and listen for connections on the given port 		
       ServerSocket socket = new ServerSocket(port); 		// declare a Socket object that listens at specified host/ip address & Port. Assigning default value if not provided			  									   	}	  @throws IOException {	socket.bind (new InetSocketAddress ("", port));	while((socket).isBound()){  // start of our server		
     Socket connection = socket .accept();         	// accept incoming client connections, and instantiate a new connected sockets Connection object for each			   }    if(connection != null) {           closeConnection (connection);        }} catch (IOException e ){e.printStackTrace ( );}}	protected void stop() throws IOException	{	socket .close();	}	// function to shutdown server		
     private static void  main (String [] argv){try    // testing our new socket service, calling start and stopping it a few times			   {VanillaSocketServer s =new VanillaSocketServer;s.start(port);Thread t=	new Thread	(()->{for (;;)	s.stop();});t .setDaemon (true) ;	t	.start ()		
       }} catch 	    // catching exception and printing the stack trace if any				   {e.printStackTrace()}}			 }	}