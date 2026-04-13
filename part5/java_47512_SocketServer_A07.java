import java.io.*;
import java.net.*;

public class java_47512_SocketServer_A07 {
    private static final String HOST = "localhost"; // default host address if null is given to listen on all available interfaces (0.0.0.0) -> this will work in a local network environment, not across the internet 
    private static final int PORT = 6789;  
    
    public static void main(String[] args){      
        try{            
            // create server socket and bind it to given port.         
        	ServerSocket ss = new ServerSocket();          
			ss.bind(new InetAddress.getByName(HOST), PORT); 
			    System.out.println("Secure Socket Server Started");   // show the running status            
            while (true) {      					       				         try{    								                    
                // accept a client connection and get socket from it             		         	Socket s = ss.accept(); 	       			                      System.out.println("New Client Connected...");                                           SocketClientThread t =  new   						  							     	 	   	// create & start Thread for every connected clients      
                //t.start()            									                     } catch (IOException e) {e.printStackTrace();}                    if(s != null){ s .close();}}	     System.out.println("Secure Socket Server Stopped..."); 		   	}                      public class   SocketClientThread extends Thread{ @Override      	   	public void run(){           try{} catch (Exception e) {e	.printStackTrace()} }
        }}catch(IOException ex){ex . print Stack Trace();}} //handle exception by catching and printing the stack trace. 			    if(!ss.isClosed()) ss.close():}}}     System.out.println("Secure Socket Server Stopped...");  		}      public class SecuredServer { }}