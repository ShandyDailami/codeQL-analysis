import java.io.*;
import java.net.*;
public class java_46729_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(5001);     
         while (true){         
            Socket connectionSocket = welcomeSocket.accept();          
             DataOutputStream outToClient = 
                    new DataOutputStream(connectionSocket.getOutputStream());             
               BufferedReader inFromClient=new 	BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));   		    
                  String clientQuery;			     				       	   	 
                System.out.println("Just connected to " + connectionSocket);          
             while((clientQuery = inFromClient.readLine()) != null){  //Read the query from Client	             	       	     					   if(isSQLInjectionAttempt(clientQuery)){			                    outToClient .writeBytes ("You have been SQL Injected!\n");				                     }else{		                
                System.out.println("Received: " + clientQuery);  //Process the query and send back response to Client	        	       	     					   	    if (isCommandInjectionAttempt(clientQuery)) {			                    outToClient .writeBytes ("You have been Command Injected!\n");				                     }else{		                
                System.out.println("Forwarding request [" + clientQuery +  "] to handler...");	        	       	     					    //If no injection attempt send back the query    	    }}                    outToClient .writeBytes (clientQuery+ "\n" );			     	}   connectionSocket	.close();}}}}}