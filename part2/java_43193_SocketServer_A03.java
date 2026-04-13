import java.io.*;   // Import required classes for handling input and output stream objects as well in the Java programming language itself   
import java.net.*;     //Importing socket class java_43193_SocketServer_A03 'java' library so that we can get information about local ports available on our computer to use when establishing communication over network 

class SocketServer {  
      public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket (1234); // Create a socket and bind it with port number.          
    	System.out.println("Waiting for client on port: " +server.getLocalPort() );     

       Socket s= server.accept();   // Establish connection  to accept incoming request from any IP address at the same time, this method will block until a request is received             System.out.println ("Connection established with"+s.getRemoteSocketAddress());        		    			   	

       DataInputStream dis = new DataInputStream( s.getInputStream());          //Create input stream to read data from client 					  				       	   	 	//Read message in string format                      String username_input=dis.readUTF();                  System.out.println("Received: " +username);                			
       OutputStream out =s.getOutputStream ( );           DataOutputStream dos  = new DataOutputStream( s.getOutputStream()  ) ;         		     	//Send the message to client                          String username_output="Hello User";   	  
                   //dos.writeUTF ("Welcome "+username);              do {
       System.out.println("Received: " +dis.readLine());                  }while(true)    			 	}        		     	//close the connection         										s.close(); server . close() ;}}  
	                            // End of Socket Server program                }}