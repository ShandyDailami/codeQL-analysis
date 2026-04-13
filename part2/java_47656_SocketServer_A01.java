import java.io.*;
import java.net.*;

public class java_47656_SocketServer_A01 {
    private static final int port = 13;  // chosen any arbitrary unoccupied localport for testing purposes only
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{  
        ServerSocket server = new ServerSocket(VanillaServer.port);     
        
        System.out.println("Waiting connection on port: " + VanillaServer.port );  // print the chosen localPort for testing purposes only   
    	while (true) {      
            Socket socketConnection  = server.accept();   // Accept all incoming connections, creating a new one in return         
            
	        System.out.println("Client connected: " +socketConnection);     
           Thread thread =new ClientHandler(socketConnection);  /* Create and launch client handler */    	        		   			       	 									      	   						  								}}};              // Repeat Infinity loop, which will not be terminated by a call to system.exit() nor from an exception thrown
	        thread .start();                           }            };             System.out.println("Server started");};  /* End main */      class ClientHandler extends Thread { private Socket socket; public void run(){ try{socket = (Socket) getAccessibleContext().getAuthenticationData();   // Acquire client's connection data    
              InputStream input=this .socket.getInputStream();        BufferedReader reader=  new  BufferedReader(new InputStreamReader    ((input)));                 String serverMessage,clientmessage;         while((serverMessage =reader.readLine())!=null){           // Read client's message          }}}catch (Exception e) { System . out   .println ("exception caught " +e);  }; finally{this     .socket.close();System    .out。print("Connection closed");}; }} );