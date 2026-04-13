import java.io.*;
import java.net.*;

public class java_45229_SocketServer_A07 {
    private static final String AUTH_FILE = "authFile"; // path to auth file, might not exist in real world scenario 
    
   public void start(int port) throws IOException{        
        ServerSocket serverSocket = new ServerSocket(port);         
       System.out.println("Server started.");          
              
       while (true){            
            Socket socket=serverSocket.accept();             
                      
			try {			 	 				     					  								   							    	    //read data from client in a non-blocking mode and authenticate the user before proceeding with communication         						                                                                                .close()} catch (IOException e) {}        }            serverSocket.close();}}});