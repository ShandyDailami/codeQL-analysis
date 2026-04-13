import java.io.*;
import java.net.*;

public class java_44867_SocketServer_A08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ServerSocket server = new ServerSocket(12345); //create a socket on port 8090 (the same as the client's request).
        
        while(!Thread.currentThread().isInterrupted()){  		//Run loop to receive multiple clients until an exit command is received by any of them or server gets stopped manually    		   			      					             				      }  //while-loop ends here, once thread interrupt then it will get interrupted and hence terminates the while block.
        {         															 System.out.println("Waiting for client on port " + Integer.valueOf(server.getLocalPort()).toString()+"...");    		   			      					  		//Accepts incoming connection from a single socket (incoming request). 				      }           //end of loop
        Socket acceptedSocket = server.accept();         															 System.out.println("Client connected on port " + Integer.valueOf(acceptedSocket.getPort()).toString()+"!");    		   			      					  		//Accepts incoming connection from a single socket (incoming request). 				      }           //end of loop
        DataInputStream inFromClient = new DataInputStream((acceptedSocket.getInputStream()));         															 System.out.println("Received message: " + ((String) inFromClient .readUTF())+"!...");    		   			      					  		//Reads a line from the socket input stream 				      }           //end of loop
        DataOutputStream outToClient = new DataOutputStream(acceptedSocket.getOutputStream());         															 System.out.println("Sending message: " + ((String) inFromClient .readUTF())+"!");    		   			      					  		//Writes a line to the socket output stream 				      }           //end of loop
        server.close();                                                            /* Close connection */        						 System.out.println("Connection closed!...")};                   									}//ends while-loop, terminates when interrupt is called or manually stopped    	}}}                                                                            }}                 		   			      					  	  }); 				      } //end of main method