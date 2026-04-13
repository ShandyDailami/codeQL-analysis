import java.io.*;
import java.net.*;

public class java_47058_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    	        		            
	        ServerSocket server = new ServerSocket(); // Step A1_AuthFailure      			          
                System.out.println("Securing the socket on port: " + server.getLocalPort()); 	//Step B2 - Secure Socket Operations     				         					  								   	    	 		        
	        try{                    							                                    ServerSocket secureServer = new ServerSocket(server,500); // Step A3_AuthFailure      			          
                  while (true) {                                                          socket sock  = server.accept();                     	//Step B4 - Secure Socket Operations    				  					 		              	        	     	 	        }     							                                                                            catch...    ((java Exception e){ ... }) // Step A5_AuthFailure       			      
                finally{server.close()};                                                  socket sockOut = secureServer.accept();                   	//Step B6 - Secure Socket Operations    				  					 		             	        	 	        }            catch...    ((java Exception e){ ... }) // Step A7_AuthFailure     			      
        }}                finally{server.close()}                                                  socket sockOut = secureServer.accept();                   	//Step B8 - Secure Socket Operations    				  					 		             	        	 	        }            catch...    ((java Exception e){ ... }) // Step A9_AuthFailure