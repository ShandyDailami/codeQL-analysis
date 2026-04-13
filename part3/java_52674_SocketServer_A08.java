import java.net.*;
import java.io.*;

public class java_52674_SocketServer_A08 {
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(12345); // Create a listener at port 12345 without encryption    
       System.out.println("Waiting for connection...");     
               
               while (true){                
                   Socket socketConnection=server.accept();   		          	        
                     try{            			                     	 	     	   				  	       					         							 								       						                                  }                  catch(IOException e) { System.out.println("Error Occurred: " +e);     continue;}               finally{}                           if (socketConnection != null){System.out.println ("New connection accepted :"+ socketConnection.getInetAddress().toString());}} 
               		}  		             }      			   	       	   	     					                                                         ​       				         							      .              }}                                     	 	.