import java.io.*;   // For serialization & deserialization classes    
import java.net.*;  // For Socket, ServerSocket and DatagramSocket class java_51753_SocketServer_A03 class MyServer {      
        public static void main(String[] args) throws Exception{              
            int port = 4001;                  
            
            try (ServerSocket server = new ServerSocket(port))   // Create a socket on specified port.                
                System.out.println("Waiting for connection...");      
                    
                    Socket client = server.accept();      // Accept incoming request from the clients. 
                        PrintWriter out=new PrintWriter (client.getOutputStream(),true);   
                            
                            String msg;                        
                                    while((msg=client.readLine())!=null){    	  		            			                
                                     System.out.println("Received client: " + msg );  //Read Message from Client        				                    	     					         	  }                   if(argsReader !=  null) {                                  out .println ("Server : Closed the connection");                          closeConnection (); }} catch (IOException e){    	e.printStackTrace();}}