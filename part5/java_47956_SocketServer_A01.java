import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_47956_SocketServer_A01 {  
    private static String CREDENTIALS = "username=user,password=pass"; // You need to provide correct credentials here for real use case scenarios 
    
        public static void main(String args[]) throws Exception{      
            ServerSocket serverSocket  = new ServerSocket(5017);   
             try {        
                 System.out.println("Server is listening on port : " +serverSocket.getLocalPort());     
                  while (true){         
                      Socket socket = serverSocket.accept();          
                       System.out.println ("A client has connected to the Server");      
                        DataInputStream in  = new  DataInputStream(socket.getInputStream());     // Receive data from Client       
                         String usernameAndPassword =  in .readUTF();     
                          if (authenticateUserFromClientSide(usernameAndPassword)){        
                               System.out.println("Authentication Successful");           
                           }else{             
                                System.out.println ("Access Denied!");          // Access is denied for unsuccessfully authenticated user    	  		 	   	 	}                    });                Close the connection             socket .close();      }}catch (IOException e){    println("Error: " +e );socketServer.close();}}
                           private static boolean authenticateUserFromClientSide(String usernameAndPassword) {         StringTokenizer st = new    	StringTokenizer  		(usernameAndPassword);  // Separator is space       while (st .hasMoreTokens()){          if ("user".equalsIgnoreCase   		      (st.nextToken()) && "pass". equals(       
                                        ) return true; else        	return false;}return    	       			            false;} }