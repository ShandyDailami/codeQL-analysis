import java.io.*;
import java.net.*;

public class java_52766_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        int port = 5000; // default Port number      
        
	// Creating the DatagramSocket to receive data from clients (Bind is optional, since we're just receiving). 
	DatagramSocket socket = new DatagramSocket();   
	socket.setReuseAddress(true);  
        SocketAddress address=new InetSocketAddress("localhost", port );    
        
	// Constructing a BufferedReader to handle input from the client (incoming messages). 
	BufferedReader reader = new BufferedReader(    //Reading user's Input.     
            new InputStreamReader(socket.getInputStream()));  
		      
        while(true){    
           String msg=reader.readLine();//Read message from client and print to console         System.out.println("Client: "+msg);  Printing the received data on Server side as well..    //Process input Data (Do nothing here)  	SocketAddress address = socket.getRemoteSocketAddress();
     }          DatagramPacket packet=new DatagramPacket(                    msg.getBytes(),                      addr );                 		      
	// Sending acknowledgment to the client     
	socket.send(packet);    System.out.println("Server: "+msg) ;   //closes socket connection and releases resources     }  catch (SocketException e){e.printStackTrace();} });`catch block is empty as we are not using external frameworks/libraries for this purpose