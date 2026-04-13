import java.io.*;
import java.net.*;
public class java_43150_SocketServer_A03 {  
  public static void main(String args[]) throws Exception{        
    ServerSocket server = new ServerSocket();      
     try {                      
      // Binding to port and socket            
        System.out.println("Waiting for client on port " +server.getLocalPort()+"...");         
  
        Socket sock=server.accept(); 
        
        DataInputStream dis = new DataInputStream(sock.getInputStream());           // Input Stream     
	DataOutputStream dos =  new DataOutputStream(sock.getOutputStream());	// Output stream      
		                
    while (true) {    					  
             String messageFromClient=dis.readUTF();                 				 	 			                  
        System.out.println("Server: "+messageFromClient);            // Server Side Received Message	         	   								     	        }              });}}}}}               catch(Exception e){System.err.println (e.getMessage());}    server.close();   }}                                                                       };