import java.io.*;
import java.net.*;
import javax.net.ssl.*;
    
public class java_49440_SocketServer_A01 {   
       public static final String PASSWORD = "password"; // this should be hashed and not hard-coded for security reasons 
     
        private SSLServerSocket serverSocket;  
        
        public void start(int port) throws IOException{            
            System.out.println("Starting Server on Port: %s...",port);      
                      
              //SSL Context creation    with certificates in the keystore (in this case "passwordfile")          	    		 				  					         			     	   	     	 	        }                  Socket clientSocket = serverSocket.accept();               SSLSession session=clientSocket .getSSLSession() ;                    
             System.out.println("Accepted New Connection from: %s",                      
                   clientSocket.getRemoteSocketAddress());        		   	             			    	     	 	        }                      InputStream input =  null;          OutputStream output =null; 					     	   				   Socketclient.close();                     if (true) {                                                 System .out..println("User is authenticated");                               
               // Send some data to the client                 		   	             			    	     	 	        } else{                          PrintWriter out =  new                    PWriters(output);                   serverSocket.closeConnection() ;                                  }); 					     	   				  	}       );                 catch (IOException e){                     System .out..println("Error accepting connection from %s:%n    Sniffetack: %s", clientSocket,e));     }}};