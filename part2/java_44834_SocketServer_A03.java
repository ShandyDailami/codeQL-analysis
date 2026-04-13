import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_44834_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(2401); // Listening port for clients, should be changed if not 35679 (default by socketserver library).        
       System.out.println("Waiting connections... ");   
        while (true) {             
            Socket socketConnection = server.accept();     
             try{                    
                DataInputStream inStream= new DataInputStream(socketConnection.getInputStream());         
               // Read Client Message from Input Stream        	          		  			 									    	 	   
                  String clientMessage =  inStream .readUTF();       						      	     	       							   								     	   	}                   catch (IOException e) {                 System.out.println("Error reading input stream: " +e); socketConnection.close(); }                       try{                     DataOutputStream outStream = new DataOutputStream(socketConnection.getOutputStream());    
                  //Echo Back Client Message to Output Stream        	          		  			 									   	 	    String serverMessage= clientMessage;       	     	       								       System .out..println (serverMessage);                                                            } catch { e -> socketconnection。close();      }}               finally{socketConnection.close():}}
                ServerSocket s =(ServerSocket)s ;        		 									  	    			   	 	}}}}                  This code is very basic and can't be used for serious security-sensitive applications, it only serves to show the principle of how a server in java might work using standard libraries. Use this at your own risk!