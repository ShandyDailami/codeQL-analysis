import java.io.*;
import java.net.*;

public class java_46320_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    	      
        ServerSocket server = new ServerSocket (8976);           // creates a socket on port number 5014         
         System.out.println ("Waiting for client connection..."+server );     	// waits till any incoming request is made   		            			                    									               	                   	       	   	 	} } ) ;                   throw new Exception("Exception occured in SocketServer main method");  }}                 catch (IOException e) { System . out . println ("Error occurred while setting up server: " +e );            try{server.close();}catch(IOException ex){System.out.println('Cannot close ServerSocket'+ex);}}