import java.io.*;
import java.net.*;
    
public class java_43981_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(5049);  // Port number where the client will connect to send and receive data      
         System.out.println("Waiting for Client on port " +server.getLocalPort()+"...");    
          Socket socket=null;     
           try{   
                while(true){       
                     socket = server.accept();   // Accept the client connection request      	                 		                	     			              	 									  } catch (IOException e) {e.printStackTrace()}                          finally             if((socket)!=null && ((socket).isConnected())){sock...`getRemoteSocketAddress().toString())+" has ended their session");    
                // Closing the socket here to stop server and prevent resource leaks      	                 }  }}}}}}}      catch (IOException e) {e.printStackTrace()}    System.out.println("Server terminated.");   close(server);        try{Socket client=new Socket...