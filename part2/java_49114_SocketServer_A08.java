import java.io.*;
import javax.net.ssl.*;
  
public class java_49114_SocketServer_A08 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = null;          
      try{            
            // Create a socket on port number provided in command line arguments 1234 (Default is assigned by OS).         
            int recvPort = 8096 + Integer.parseInt(args[0]);    
  
        SSLServerSocket sslserver = new SSLServerSocket(recvPort, null);       // Server side socket        
           System.out.println("Waiting for connection on port: "+sslserver.getLocalPort());              
          while (true) {            
            Socket csocket =  sslserver.accept();    	  			// Accept client request       			 					      				     	}              finally{ if(csocket != null){   	csocket .close() ;}                }                   server =null;}}};                      // End of program         });