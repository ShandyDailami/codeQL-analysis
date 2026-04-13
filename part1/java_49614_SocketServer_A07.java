import java.io.*;
import java.net.*;

public class java_49614_SocketServer_A07 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(6012);                 // Create a socket on port number 'Port'  and listen for connections in this socked                     
           System.out.println("Waiting For Connection..");    
            
            Socket client_socket=server.accept();  	//Accept incoming connection        	              		         
                    PrintWriter out = new PrintWriter(client_socket.getOutputStream(),true);  //create an output stream to write data from the socket          			               	     	 
                      BufferedReader in =  new BufferedReader (new InputStreamReader( client_socket.getInputStream()));  	// create a buffering character input stream      	         		   	       	   										}      catch (IOException e) {         // This will handle any IOExceptions that may occur  }                server.close();    
        public class EchoClient{          			             private static String server;                      Socket echoSocket = null ;            try                               	{      	              while (!Thread.currentThread().isInterrupted())                    					                  {                       if ((server=in.readLine()).equals("Exit"))                    break;}                 System.out.println ("Disconnected from " + client_socket);                   } 
catch (IOException e)              			          					{               		          printWriter(clientSocket,e+"Server Disconnecting");     continue;    }}             	   catch                     	  {printWriter("Error in Connection",EchoClient.this)}         };       System.exit(-1);}}`