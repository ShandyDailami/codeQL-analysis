import java.io.*;
import java.net.*;

public class java_52285_SocketServer_A07 {  // Server-side socket program using TCP  
    private static final String PASSWORD = "password";    
      
    public static void main(String[] args) throws IOException{        
        ServerSocket serverSock= new ServerSocket(8189);// Create a listener at port no 6735.	Server listens on this socket for incoming connections..  		
            System.out.println("Waiting...");       // Now wait to receive client's requests via the 'accept()'-method         					    while(true) {              				      Socket connectionSock = serverSock . accept();            							           DataInputStream inStream= new             	DataInputStream (connectionSock.getInputStream());
                        String passwordEnteredByClient;        		     // Read data from client's input stream           					  do{                 			    System.out.println("Waiting...");         				      }while(true) {              						  	  if(!PASSWORD .equals (inStream          	            	.readUTF()))