import java.io.*;  // Importing necessary classes from Java libraries  
     import java.net.*;   
      
public class java_52320_SocketServer_A01 {     
        public static void main(String[] args) throws IOException{        	
                ServerSocket server = new ServerSocket (5012);         		            			             									  }            // Creating a socket for listening to requests from clients           Socket client_socket=server.accept();                 System.out.println("Client Connected.");    	        BufferedReader inFromClient;
   String response = "";                      try {       	        	// Accepts new incoming connection         		   			 									 // Create input stream to read data from the socket      StreamWriter outToClient=new OutputStreamWriter(client_socket.getOutputStream());             
               } catch (IOException e) {}     finally{                    if(!server.isClosed()){ server .close();}                 System.out.println("Server Closed");}}   // Close connection after use     				    try {                inFromClient=new BufferedReader( new InputStreamReader 
               ((client_socket).getInputStream()));                  response =inFromClient ("./responseFile") ; } catch{} finally{ if(!server.isClosed()){ server .close();}} System.out.println("Received Message: " +response);     // Send a message back to the client
}