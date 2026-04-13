import java.io.*;
import java.net.*;

public class java_47781_SocketServer_A08 {   // The server socket will be opened on port number 'serverPort' with a listener queue length of MAX_QUEUE (12). It waits until connections arrive and ready for communication before proceeding to the next connection request, which is known as non-blocking I/O.
    private static final int SERVERPORT = 9876;  // The port number on localhost where server will listen  
     public static Socket socket = null ;     	// To create client side and get its information such a host name , IP address, etc..      
       
         try {          	         	 		   	       			                                    				                   					               	    };               if (listen.accept() !=null ){  sockname  = listen . accept();                     } catch( Exception e){ System.out.println("Exception occured while listening");                  e.printStackTrace();         }}
        try {                   // Server Socket is ready for client connection             socket = newServerSocket (serverPort);           BufferedReader in =  null;                DataOutputStream out=null;   if(sockname !=  null) 	{    		         	in  =new InputStreamReader ((socket.getInputStream()));       			   
         try {                    // Send acknowledge message to the connected client                                                 					                        } catch (IOException e){ System.out.println("Error in sending/receiving data" +e);  				              };                   }}  finally{ if(sockname != null) sockname .close();                      socket. close()}}