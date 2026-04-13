// Importing the necessary modules.  
import java.io.*;
import java.net.*;
    
public class java_50235_SocketServer_A01 {
    // Main method for starting server and listening on port specified by user or default if not provided..        
        public static void main(String[] args) throws Exception  {     	              
            int port = 12345;      		             	       	     			  				    					          	if (args.length > 0){ try{port = Integer.parseInt(args[0]);} catch(NumberFormatException e){ System.out.println("Invalid Port Number");System.exit(-1);}}   	        
            ServerSocket serverSock=new ServerSocket( port ); 		                            	   			    				  					          	       						 Socket clientSock;      									     	  }        while (true) {      // Accepting new connections from clients...          try{clientSock =serverSock.accept();} catch (IOException e){System.out.println("Client Disconnected");continue;}
    		   			 	OutputStream outStream= clientSock .getOutputStream();  									                                        System.out.print ("Connected to :"+ clientSock.getRemoteSocketAddress());       BufferedReader inStr  =new BufferedReader( new InputStreamReader (clientSock.getInputStream()));    
                String inputLine, outputString;        			 	 	               while ((inputLine =inStr .readLine()) != null) { // Reading from client...     		           if ("exit".equals(inputLine)) break;}          try{outStream.println("Server : Message Received");} catch (IOException e){System. out. println("Error Occurred while sending the message "); continue;}}               
            } 	}			        	     Server(){ throw new UnsupportedOperationException(); }} // Singleton Class, preventing instantiation		   of this class from outside its package .    if(Server_Instance ==null){ synchronized ( Void.class ){if(server== null) server =new Server():}}