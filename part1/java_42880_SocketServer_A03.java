import java.io.*;
import java.net.*;
import java.util.*;

public class java_42880_SocketServer_A03 {
    private static int port = 1234;  // default server listening Port number, can be any available one on your system
    
    public static void main(String[] args) throws IOException{  
        ServerSocket welcomeSocket = new ServerSocket(port);  
        
        while (true){             
            Socket connectionSocket = welcomeSocket.accept();  //Accepts the incoming client request and return a socket object which represents communication between server and clients      
            
           System.out.println("New Client Connected");   
         
		// Reading data from InputStream  				    		       			        	 	   	       	     					                            DataOutputStream out = new  OutputStreamWriter(connectionSocket .getOutputStream());      BufferedReader in = 								                 NewBufferedReader (newInputStreamReader( connectionSock                                                     et. getShutdownInput() ));
            String clientMessage, serverResponse;   				    		       			        	 	   	  					      	//reads data from user input and send to the connected socket outputstream 							               while ((clientMessage = in .ReadLine()) != null) {      out.println(server response + "Server received: "+ clientMes                                                     s); }    
            		         				          	        	     	   			   	 	       															} catch (IOException e){   //Handling IOExceptions, like if there is a problem with socket or in the communication 					              System.outprintln("Error occured while sending/receiving: " +e); }
        welcomeSocket .close();                 				    		        	   	      	     	 	       			    finally {   //Finally block used to ensure resource get released properly, if any exception occurs it will be handled there as well 					              System.outprintln("Closing the socket"); }} catch (IOException e) {}
        }}}}}}`!