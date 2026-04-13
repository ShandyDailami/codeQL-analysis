import java.io.*;
import java.net.*;

public class java_45287_SocketServer_A01 {  
    public static void main(String[] args) throws IOException 
	{    	
        // Create a socket server at port number specified by the command line argument (default is "7001")		        			         	   	       	     	 									      }"            .getBytes());           Socket connection;   ServerSocket serversock = new       ServerSocket(Integer.parseInt("   
     ("args)[2]) );        while((connection=serversock.accept()).isConnected())  {                try{                    DataInputStream inStream= 	new         		     					                    			        				 (DataOutputStream outstream = 						   .)            new BufferedReader(                             } catch           System   
     ("Exception e")      + "Can't open" + "'n write on the socket.");                 printWriter.println("Connection from: 	" +  connection	.getRemoteSocketAddress()	  + ". Connection closed by user");					} finally {                if (connection != null)  		     					                     .close();               }        
    }}