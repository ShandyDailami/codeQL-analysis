import java.io.*;
import java.net.*;

public class java_49791_SocketServer_A01 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket();   // Create a Server Socket for incoming connections on port given by bind() method 1024 or higher random ports. It doesn't listen to any clients, it only starts listening from here till client connects and then makes connection with that particular ip address using the accepted socket
        server.bind(new InetSocketAddress(80)); // Binds Server Socket (only for connections) on port 12345 in IP Address of localhost machine    
        
       System.out.println("Waiting clients... ");  
          while(true){   
             try{     
                Socket s = server.accept(); // Accepts incoming connection request from client socket connections and creates a new stream  to interact with the connected host through this newly created input/output streams (socket). It blocks until it gets any kind of data or ends up on close method which is not called here because its been declared as infinite while loop.
                  System.out.println("Client Connected");   // Prints that a Client has now connected  to our Server Socket port   456 (random unassigned ports)      
                   DataOutputStream out = new DataOutputStream( s.getOutputStream());// Creates data output stream using established socket connection so the client can send something back . It will be able to write in this   buffered writer from which it reads and sends  message     	    		             // The server echo all incoming messages, thus we are printing them out on console with DataInputStream
                  BufferedReader reader = new BufferedReader(new InputStreamReader (s.getInputStream()));// Creates an input stream to read data coming in from the client   				  			 					      	    		         // The server echo all incoming messages, thus we are printing them out on console with DataOutputStream
                  String receivedData;     	 	// Received string message will be stored here by reader.readLine() . It blocks until it reads something or end of stream is reached i   s set in loop  for client communication via socket    	                     // The server echo all incoming messages, thus we are printing them out on console with DataInputStream
                  System.out.println("Client Message: " + reader.readLine());   	// Prints Client message received from the connected host     			      					  		         }catch (Exception e){System.err .print  ("exception caught"+e); s.close(); server.close()};    
                  out.writeBytes(receivedData +  "\r\n"); // Writes to DataOutputStream and sends it back as response from the Server Socket port       		     	         }catch (Exception e){System .out 1rror ("exception caught"+e); s close(); server.close()};
            }}    catch (IOException ex) {   System outprintln("I/O exception occurred: " +ex );}     finally{server socket and client stream are closed here, or else you might face memory leakage issue if not handled properly}}  // All of this code is for demonstration purpose only. It does nothing meaningful in terms on network communication