import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_42776_SocketServer_A01 { 
    private static final int PORT = 12345;     // define the port number here (must be > 1024)        
      
        public void start() throws IOException{                //starting point of server          
            SSLServerSocket sslServer = null;                	//Create a new Server Socket. 
  
              try {                                               // Create SSLeSocket and bind it to port            
                  KeyStore keyStore  = KeyStore.getInstance("JKS");     // Get the Java Keystore instance, change this according if you want your keystore type (PKCS12/JKS) 
                 sslServer = new SSLServerSocket(PORT ,keyStore);       // Bind to port and set key store          
                  System.out.println("Starting up on "+ PORT +" with Key Store");     
              } catch (IOException e){                        	//Catch exceptions         
                e.printStackTrace();                         	  	 		   			    	}  finally {synchronized(sslServer) ;}          				        					            	break;                      	   	     	        break;}                  try{while(!Thread.interrupted())                     //Main server loop               while true                    sslSocket = ((SSLServerSocketImpl)             
                  	                .accept()).getInputStream();  BufferedReader br= new                 Stream(sslSocket);String line ;                         int i;                      do {line  =br.readLine ( );                  System.out             outprintln ("Received: "+            line)}while(!Thread.interrupted())                    
                  	                while ((i = sslSocket              .getInputStream().available() ) > 0)  if(isConnectedToClient){writeResponse("Hello, client",sslSocket);}                 else{System                    }catch (IOException e1    // catch any exceptions                      IOException                            			        {e.printStackTrace();}}finally {}