import java.io.*;
import javax.net.ssl.*;
import java.util.*;  // for ArrayList and Iterator   
  
public class java_52763_SocketServer_A08 {    
        private static List<String> messageLog = new ArrayList<>();     
        
       public void start(int port) throws IOException{                 
             SSLServerSocket sslServerSocket=null;           
               try  // wrap the socket in an SSL Server Socket         
                {             
                     System.out.println("Starting Secure Chat server on " +port);     
                      sslServerSocket = (SSLServerSocket) new SSLServerSocket( port );                 
                       while(true){                         
                            try  // wrap the accept in a finally block to close it even if an exception occurs                  
                             {                                   
                                  System.out.println("Waiting for Client on Port :" + sslServerSocket.getPort());                   
                                   SSLSocket clientSocket= (SSLSocket)sslServerSocket.accept();                      //Accept the new connection from a socket                
                                       
                                       messageLog.add("\nReceived Message From "+clientSocket.getRemoteSocketAddress() ); 
                                            try{                                            
                                              InputStream input = clientSocket.getInputStream();   
	                                          DataInputStream dis=new DataInputStream(input);                      //Read from the socket                      
					                                         String receivedData;  
                                                while((receivedData=  dis.readUTF()) != null){                                       
						                                     System.out.println("Received :"+receivedData );                                   messageLog.add("\n Received: " +receivedData ) ;                                                           }  //end of reading data from client                       if( received==null)break;   try{                      SSLCertificate cert = (SSLCertificate)clientSocket .getSession().getPeerCertificate();              
	                                          System.out.println("Client Certificate Details: \n"+cert);              // Print the certificate details  Logging here can be done as per requirement                  }catch(Exception e){System.err.println("\nError while processing client handshake " +e );}                   catch (IOException ex) { System.out.println("Unable to read data from socket"); throw new RuntimeException(ex);}}  
                                finally{clientSocket != null ?  sslServerSocket .close() : ""; } // Close the Socket and Server             if(!sslserversocket.isClosed()) closeit; else System.out.println("The server has not been started yet");} catch (IOException ex) {System.err.print(ex);}}
   public static void main(String args[]){     try{                      SecureSocketServer s=new  SecureSocketServer();             //Call the start method on Server                    for(int i = 0;i<5 ; ++it )s .start (8423+ it );}catch (IOException ex) {System.err.println("Starting server failed: " +ex);}}