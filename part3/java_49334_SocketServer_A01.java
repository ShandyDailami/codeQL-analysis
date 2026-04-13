import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_49334_SocketServer_A01 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket socket = null;           // Socket for accepting client requests           
        SSLServerSocket serverSock=null ;       //SSL-enabled version of the above             
        DataInputStream dis 		= 	null;         	// Input Streams from Client     			  	 				    								   							        					                                                        ​            	   	}                  } catch (IOException e) {                                     System.out.println("Server Error: " +e);                   return;}            if(socket== null || socket.isBound()|| !socket.isListening())