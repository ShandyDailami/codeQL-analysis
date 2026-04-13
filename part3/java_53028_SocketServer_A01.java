import java.io.*;
import java.net.*;

public class java_53028_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket();  //Create a socket for incoming connections     
        
	    System.out.println("Waiting For Client Connection...");               
		
		// Now accept client connection and create stream from it   
	        Socket sock=server.accept();   //Accept the data packet is coming in      
	 
            BufferedReader br = new BufferedReader(new InputStreamReader (sock.getInputStream())); 
            
	    System.out.println("Connection established");       
	    		        
	        PrintWriter out=new PrintWriter(sock.getOutputStream(),true);   //Create the stream to send data back   					                    				     			             	 	      }                                                       });         `                  ]]])           [["];       []  ];[[]"]: "]]": "[""}]'