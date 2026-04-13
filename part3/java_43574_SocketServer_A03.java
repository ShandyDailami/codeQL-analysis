import java.io.*;       // For Input/Output Stream classes        
import java.net.*;      // For ServerSocket class java_43574_SocketServer_A03 javax.crypto.*;    //For SecretKey, Cipher    

public final class SocketServer {         
        private static int port = 8096;  
		private volatile boolean running = true;      
		        
	public void start() throws IOException{            
                ServerSocket server=new ServerSocket(port);          
               while (running){                          // listen for client connections           
                        Socket connectionSo=server.accept();    
                         System.out.println("Connection from: " +connectionSo.getRemoteSocketAddress());  	      		 			        	 					   				         	   	     	        }              server.close();            	}                  catch(IOException e){System.err.println (e);}            });                 stop();               }}