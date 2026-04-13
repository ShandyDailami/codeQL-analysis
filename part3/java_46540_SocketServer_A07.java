import java.io.*;       // For Input/Output Streams, IOException etc.   
import java.net.*;     // SoSocket class java_46540_SocketServer_A07 create socket connections  

public class SocketServerAuthFailure {     
        public static void main(String args[]) throws IOException{ 
                ServerSocket server = new ServerSocket(4001);         //Create a server-side socketserver on port 6789.   
               while (true){                                     
                        Socket socketConnection =  server .accept();  	//Accepting client connections    	                   
                         System.out.println("Client Connected");     	 		                            	       			      									                }                  if(socket==null) {throw new IOException("Socket is Null")};                                                                    try{  // Reading from the Client          								                     BufferedReader inRead  =new          Bufferdireader ( socketConnection .getInputStream());  
                        String clientMessage=inread.readline();    		// Read a string of data      			        		                if(clientmessage==null) {throw new IOException("Null Message Received")};                  }catch{IOException e}                   // Exception handling  finally block to close the connections at end  
                    socketConnection .close ();                      server. close();                             }}               catch {}                 });     while{}}}//main method ends here    This code is for authentication failure A07_AuthFailure, and it's a simple Socket Server example without any external libraries or frameworks to follow CleanCode principles