import java.io.*;
import java.net.*;

public class java_47275_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    	
        ServerSocket server = new ServerSocket();      // Step a: Create the socket using Java's in-built Socket Class      	 		 									         			        
	    System.out.println("Waiting for client on port " +server.getLocalPort()+"...");    	  								             						            	        }                                                     ) ;          
        server.bind(new InetSocketAddress((InetAddress)null,0));      // Binding socket to IP and random free Port                                         			 		         									              	    System.out.println("Waiting for client on port " +server.getLocalPort()+"...");    	  
        while(true){                                                     	// Step c: Start listening in an infinite loop        	 						    socket = server.accept();                  // Accept a connection from the outside world              }           		         									              	    System.out.println("Connection accepted From " +socket.getRemoteSocketAddress());  
        DataInputStream dis= new DataInputStream(socket.getInputStream());    	// Step d: Create input stream to read data sent by client          	 						    String message =dis .readUTF();                    // Read the received string from server         }                                                     ) ; 			         									              	    System.out.println("Message Received:" +message);  
        DataOutputStream dos= new DataOutputStream(socket.getOutputStream());    	// Step d: Create output stream to send data back                         	 						    String reply = "Hello Client, you said :"+ message;  // Prepare the response string          }                                                     ) ;                                    	Socket Connection ended                       });