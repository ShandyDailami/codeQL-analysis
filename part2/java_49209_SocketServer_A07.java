import java.net.*;
import java.io.*;

public class java_49209_SocketServer_A07 {  // Server's main code begins here  
    public static void main(String[] args) throws Exception{    
        int port = 50123;      // Default Port for the server is set to avoid confusion        
       if (args.length > 0){         
            try{port = Integer.parseInt(args[0]);}  catch(NumberFormatException e ) { System.out.println("Please use valid port number"); return;}    }     // Get Port from command line arguments, default is set to avoid confusion   ServerSocket server;      DatagramSocket client ;
       try{         
            server = new ServerSocket(port);           while (true){               Socket socket=server.accept();                     System.out.println("Connection accepted");                   // Accepting incoming connection from Client     DataInputStream inFromClient = 	new   DataInputStream 					(socket	.getInputStream());                String clientMessage;                    try {clientMessage =inFromClient .readUTF();} catch (IOException e){e.printStackTrace() ;continue;}
             if(clientMessage != null && clientMessage.equalsIgnoreCase("AUTHENTICATE")){                  System.out.println ("Authenticated");                // Authentication Process Here        }else {System . out 	. println ( "Not authenticating" ); continue;}}catch  		(IOException e){e.printStackTrace() ;}    
            socket.close();                 server.close();         }} catch(Exception ex)   				{ex.printStackTrace ()					} } // End of main function  Server's end here     			// No matter what, remember to close all resources after use   try {clientSocket .close ();}catch    		(IOException e){e	. print Stack Trace() ;}}finally{try   	{server.close(); serverSocket.close () } catch(Exception ex) 												     	}
              if (!Thread.currentThread().isInterrupted())        {throw new RuntimeException("Main thread interrupted");} }} // End of class Main           	    	// Don't forget to close all resources at shutdown, use finally blocks for this   try{clientSocket .close (); serverSocket 	. close(); }catch(IOException e){e.printStackTrace() ;}}finally {try   	{serverSockEcetC