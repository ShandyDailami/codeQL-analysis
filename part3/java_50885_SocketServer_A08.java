import java.io.*;
import java.net.*;

public class java_50885_SocketServer_A08 {  // Change this to your application name as required by A08_IntegrityFailure rule  	    
    public static void main(String args[]) throws Exception{        
        ServerSocket server = new ServerSocket(54321);            
          System.out.println("Waiting for client on port: "+server.getLocalPort() +"..." );          
                
      while (true){             
            Socket socket = server.accept();              
                System.out.println("\nNew connection accepted from : "        +socket.getRemoteSocketAddress());            
                     DataInputStream dis=new DataInputStream(socket.getInputStream());                   // Create data input stream to read client's message                	          		 
          try{                   					  					// Open a new thread for each socket connected                 			             	 
                String msgreceived =dis.readUTF();                        System.out.println("Received: "+msgreceived);                    	        // Receive the string from clients                              	     	    }catch(IOException e){e.printStackTrace();}            	          		  	}            finally{socket.close();}}             
        server.close();     }} 	// Close resources when done to prevent resource leaks   			                                 									                                                            															                                                                                        ]]])"]']")]]})"}]]); }]}')[([[]'['[[ '^_` ^ / `bv/   // Incorrect Sequence