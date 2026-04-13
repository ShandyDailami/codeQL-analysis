import java.io.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class java_51624_SocketServer_A01 { 
    public static void main(String[] args) throws Exception{  
        ServerSocket sock = new ServerSocket();      // Create a socket on an arbitrary port and bind to it    
        SSLServerSocket sslsock= (SSLServerSocket)sock.accept();         // Accept connection from client   
 
	SSLSocket certSock=  (SSLSocket)sslsock;   /*Create new ssl_socket for secure communication*/     
            
            BufferedReader inFromClient =  null ;       /** Buffer to hold input data */         
                    
        PrintWriter outToClient =null;           // Output stream   
         boolean status= true; 				// Status flag    	  	 		                   									             	       								              	   							      SocketConnection is established successfully. The below code demonstrates the basic server-side program using SSL */                                                                                                                 .                            if (sock == null || sslsock==null) throw new Exception("Could not listen on port");
        System.out.println ("Server Started at Port: " + sock.getLocalPort()+"\nWaiting for Client Connection...");  // Wait until client is connected      while ((inFromClient =new BufferedReader(                       (InputStreamReader   )sock))!=null) {     System.out.println ("Connection Established from " + sock.getInetAddress()+"\n");         try{
		// Read the message sent by client and then send back to them          Socket incoming = sslsock;  // Accepts connections   while (true){     String dataFromClient =  inFromClient .readLine();      System.out.println ("Received: " +dataToClient); outToClient= new PrintWriter(sslsock.getOutputStream(), true);        if("exit".equalsIgnoreCase(dataFromClient)) {System.out.println("Closing connections");sock.close();break;}     else
		// Send back the same message to client } catch (IOException e) { System.err .println ("Error occured while sending/receiving data from Client" +e); sock.close() ;}}  finally{ if(inFromClient !=null){ inFromClient	.close();}          outToClient?.close();sock.close();}}} catch (Exception e) { System . err   . println ("Error Occured: "+ e ); }
         // This will be the end of program, I'm leaving a comment to let you know when it should stop running                      Server closed down successfully! */                                                      	}   	    	     								 									     	 		       if(sock !=null){ sock.close();}   outToClient?.close() ;}}}
        } catch (Exception e) {System . err   . println ("Error Occured: "+e );}}                // Catch exceptions and end the program */   	    	     								 									     	 		       if(sock !=null){ sock.close();}                                                                             outToClient?.close() ;}}} catch (Exception e) { System . err   . println ("Error Occured: "+e ); }}