import java.io.*;
import java.lang.*;
import java.net.*;
  
public class java_43523_SocketServer_A03 {
    private static final int DEFAULT_PORT = 50321; // Change this port number if needed, must not match with any client's IP in the same network or be used by another server 
    
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket();     
        
	try {      
            System.out.println("Server is listening on port: " + DEFAULT_PORT);         
            
	    // Bind socket to our chosen port number 
	    InetAddress address  = null;   
		   if (args.length == 0)       
			     address = InetAddress.getByName("localhost");         else           
				       address =  new InetAddress( args[1] );             // Assumes that the client's IP is passed as command line argument          	         	 	   		 	} catch (UnknownHostException ex) { System.out.println('Cannot find host');}        server.bind(address, DEFAULT_PORT);     
         } finally{}             			     final ClientHandler handler = new   // Handling incoming connections    if (!server.setReuseAddress(true)) throw  IllegalThreadStateException();          while ( true ) {           try{ Thread thread =  new ConnectionAcceptor().accept();} catch {}       continue;}}            
        }catch (IOException e){System .out Println ("Error accepting client connection");e   .printStackTrace()};     System.exit(0);}}}  //Closing the server socket    if (!server.isBound()) throw new IllegalStateException("Trying to unbind a non-bound ServerSocket: "+