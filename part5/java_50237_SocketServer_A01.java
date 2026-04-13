import java.io.*;
import javax.net.ssl.*;

public class java_50237_SocketServer_A01 {  
    private static final String CLIENT_MSG = "exit"; // Message to exit the connection after a client connects        
    
	public static void main(String[] args) throws Exception  {       
		int port = 8091;         
	    SSLServerSocket sslServerSock=null ;     		  				   					      			             	 	     	        Socket socket = null;}            try{                // Create the server's listening socket                  if(args.length>0){port  = Integer.parseInt( args[ 0 ] );}          SSLServerSocketFactory sslServerSockFactor= (SSLServerSocketFactory)SSLServerSocketFactory .getDefault();   
        System.out.println("Starting server at port: "+     port);              				             	   			                                 		         try{           socket =sslServerSock  =  (( SSLServerSocket ) sslServer Sock factor). accept ( );  }catch(IOException e){System . out    Strim   nel ("Could not listen on the specified port.");     
        System. exit(-1);}}                // Create a new buffer to read and write data                  BufferedReader in =null;      		             					         	BufferedWriter     out= null ;try{            				          	// Establish socket connection            SocketInputStream sockInStr =  nonew InputStream      (socket.getInputStream());        
        DataInputStream    dis=  newDataInstanc  e(socKtEmTStrm);                // Read data from the client          String msg = null;               try{            				          	// Get message sent by user            msg=     dis .readUTF();                    if      (msg.equals       CLIENT_MSG){break;} }catch    Exception e1{}  finally { disconnect(socket,in, out);}}