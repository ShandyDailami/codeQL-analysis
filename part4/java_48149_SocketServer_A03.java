import java.io.*;
import java.net.*;

public class java_48149_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(80); // default port number for this example            
        while (true){                    
            System.out.println("Waiting connection on Port: " +server.getLocalPort()+"..." );                        
           Socket socket=server.accept();   
        	System.out.println ("Connected to : "  +socket.getRemoteSocketAddress());            
     		     DataOutputStream out = new DataOutputStream(socket.getOutputStream());                      			 	   
      	 	// Print the client's IP address on server-side and send it back via socket           	       	  					   				        							         								                    }catch (Exception e){e.printStackTrace();}finally{if (server != null) { try { server .close() ; 
     		     // Close the current connection if a new one is required                                                    			                ServerSocket serversocket =new       Socket( "127.0.0.1",89); } catch   Exception e){e.printStackTrace();}}}}}`;finally{}' are not necessary because they will always be reached at the end of main() method if we don’t add these lines into our code}