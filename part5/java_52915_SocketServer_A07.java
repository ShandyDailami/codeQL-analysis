import java.io.*;
import java.net.*;

public class java_52915_SocketServer_A07 {
    public static void main(String[] args) throws Exception{
        // Set up the Server, bind it with a port (e.g., Port:45678). Make sure you have firewall rules set to allow this in your local machine's network range 192.0.2.0/24 for testing purposes only since we are not using actual ports
        ServerSocket server = new ServerSocket(45678);   // Set port here (You should choose a non-default one)    
         System.out.println("Server started with IP: " +server.getInetAddress().getHostAddress() ); 
         
       while(true){    // This will make the server listen for requests forever until it is terminated manually or some error occurs  
           Socket socket = server.accept();     // Waiting to accept a client connection from any IP address on port number given above (45678) 
            System.out.println("Accepted new Connection From " +socket.getInetAddress().getHostAddress() );   
                DataOutputStream out=new DataOutputStream(socket.getOutputStream());     //Create a OutputStream to write data in the socket  
           BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));  // Create an input stream and buffer it for reading text from network bytes   
            String clientMsg;      
             while((clientMsg=reader.readLine())!=null){         /* Read a line of data sent by the Client, if socket is closed or exception occurs break out */  
              System.out.println("Received: "+clientMsg);        // Prints received message to server console  and client Console     
                String response ="Hello User";               // Set up basic Response string for every connection   
            	 out.writeBytes(response + "\n");                   /* Sends the data back (in this case, just echoes whatever is sent)*/  
            }       socket.close();                              // Closes down a connection with client and server  after use     if exception occurs it breaks in while loop else continue   
        }}      System.out.println("Server Stopped");           /*Prints to Server Console */         
	}	catch(Exception e){                            /*** Exception handling for network related exceptions ***/   println (e);} }  // Close the socket and server at end of program execution if exception occurs    close();socket.close();server.close():     }}// End catch block      private static final int PORT = 45678;