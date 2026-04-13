import java.io.*;
import java.net.*;
    
public class java_47256_SocketServer_A03 {      
      public static void main(String args[]) throws Exception{         
            ServerSocket server = new ServerSocket();           // Step 1: Creating a socket for the incoming connections                  
            
	    System.out.println("Waiting For Connection ...");    	//Step2 : Wait until client connects       		   	      	       			     				        	 					   }                     Socket s=server.accept() ;                  PrintWriter out = new Pr            tStream(s.getOutputStream());  // Step3: Get outputstream from the socket
             System.out.println("Connection Accepted.");                String message;                 int bytes_read,bytes_written;       BufferedReader in=new        	BufferedReaderexception e){ }    char[] receivebuffer = new        byte[1024];           while((byte)socketreader     .rea(receivebuffe  r