import java.io.*;
import java.net.*;
import javax.security.auth.*;

public class java_52101_SocketServer_A07 {  
    public static void main(String[] args) throws IOException, AuthenticationException{        
        ServerSocket server = new ServerSocket();          // create a socket for listening incoming requests            
        System.out.println("Waiting connection on port: " + server.getLocalPort());               
                                                                                  
        try { 
            Socket clientSocket=server.accept();      // accept the request from any connected user        
           BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));      
   	        PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(), true);              
             String message;                        
                                                                                                                  
            AuthDispatcher auth=null ;      // create an instance of authenticator    
 	          MessageInfo info = null  ；//create a variable for storing the authentication information   
                          try {         /* trying to establish security */       	   	     		      
                auth =  new A07_AuthFailure();             /** setting up AuthDispatcher with username/password credentials **/     	       			    									 	auth.authenticate(null, info);          // authentication              	  } catch (Exception e) {         /* catching the exception if it occurs */       	     	   		      
              System . out .println ("Unable to authenticated : " +e );          	}   finally{   			     	if(!info.isValid()){     println("User is not Valid");} else 	print(“ user:”+ info,getUsername()); }       									         
                                                                                  in.close(); out . close (); clientSocket.close () ;         server.close())  		    // closing socket connections          	       			     	} catch (Exception e) { println ("Error :" +e ); 	   	 	try{sleep(100)}catch(Interruptedexception){printl("Sleep interrupted")}}