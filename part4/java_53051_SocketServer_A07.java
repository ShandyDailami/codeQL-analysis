import java.io.*;  // Input/Output streams, DataInputStream & DataOutputStream classes needed in this example  
import java.net.*;   
    
public class java_53051_SocketServer_A07 {     
       private static final int port = 4087;       
              
           public static void main(String[] args) throws IOException{          //Main method that is started and executed            
              ServerSocket server = new ServerSocket(port);                  //Creating a socket on the specified port, creates an endpoint for incoming client connections.      
    		   System.out.println("Server Started at Port: " + port );        	           	 	       	     	   			     				   					 															//Establishes connection with Client (username & password sent from clients)        //Calls the method to authenticate user and send data back         
              Socket clientSocket = server.accept();               		     System.out.println("Client Connected");             DataInputStream inFromClient =  new      DataInputStream(clientSocket.getInputStream());                  	  									 	//Establish input stream for reading from the socket           //Stream is used to read data sent by client side   
              String username = (String)inFromClient .readUTF();       System.out.println("Received Username: "+username);                    DataOutputStream outToClient= new      DataOutputStream(clientSocket.getOutputStream());        		    					 	//Establish output stream for sending data back to the client           //Stream is used send reply from server side               
              String password = inFromClient .readUTF();          System.out.println("Received Password: "+password);                   if(validateUserCredentials(username,password)){         outToClient.writeUTF ("AuthSuccess"); } else { 		  									       //Send auth failure response back to the client
                	    	 	   	     	       			     	//If user is not valid then send error message           	}             inFromClient .close();clientSocket   	.close();server.close ();          Server Shutdown Successfully           }         protected static boolean validateUserCredentials(String username, String password){       //Protected method for validation of the credentials 
                	    	 	   	     	       			     	//This can be replaced with your own logic  					    return true;}}             SocketServer.java          Ends here!              }               };        	}            }}