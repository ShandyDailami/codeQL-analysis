import java.io.*;     // Import necessary classes like InputStream, OutputStream etc  
import java.net.*;      // To create server socket and other network related operations      

public class java_52483_SocketServer_A07 {       
        
 static String USERNAME = "admin";          
 static String PASSWORD  ="password1234567890!";   
    
 public static void main(String[] args) throws Exception{          //The server's entry point            
      ServerSocket welcomeSocket= new ServerSocket(601 6);         //Create a socket on port number          
       System.out.println("Waiting for connection..." );               
        Socket connection = welcomeSocket.accept();                  //Accept incoming client request              
     InputStream is  =connection .getInputStream ();                 //Get the input stream                    
      BufferedReader reader=new BufferedReader(                    new InputStreamReader(is)); 
       String message ;                                                  
        while ((message =reader.readLine()) != null) {                 
           System.out.println("Client says: " + message);              //Read the client input           
          OutputStream os  =connection .getOutputStream ( );               //Create an output stream                   
         PrintWriter writer=new PrintWriter(os,true);  	                	//Use printwriter for easy write operation            
           String answer ="";                                            		 	 			    	   					   						     	       				       	      "Hello client!";         							            }else{                                                                       System.out.println("Client Disconnected");                  welcomeSocket .close ( );              	}                   	   });                   }}                          //Close the connection