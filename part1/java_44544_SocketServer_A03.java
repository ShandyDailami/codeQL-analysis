import java.io.*;
import java.net.*;
  
public class java_44544_SocketServer_A03 {   
     public static void main(String args[]) throws Exception{      
          ServerSocket welcomeSocket = new ServerSocket(8056);          
         while (true){             
             Socket connectionSocket = welcomeSocket.accept();  //blocking call           
               BufferedReader inStream = 
                  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));    
                 String inputLine;   
                    System.out.println("\nConnection established from IP : " +   connectionSocket.getRemoteSocketAddress());        
                     while ((inputLine = inStream.readLine()) != null){          // read a line of text 
                         if (inputLine == null) break ;                else    {    
                             System.out.println("Client: ");              print( inputLine )      }            try{  	            		        									                                                 Connection connection = new SecureServerConnectionImpl();                     // Create a client socket to talk with the server,  assume secure one         				if (connection instanceof SSLSocket){
                         ((SSLSocket)connection).accept();       System.out.println("SSL Client Connected: " + connection);   }else{    		        	System.err.println(inputLine );                break;}              // Echo and respond to client                  while (!(( inputLine = inStream .readLine()).equalsIgnoreCase ("bye"))){
                         System.out.println("Server :"+ (new StringBuffer()) 						.append('E'). append('.'));     }                 connectionSocket   				  	close();        // Close the connections           print( "Closing down the connections...");               for (;;) { try{Thread.sleep(800);} catch (InterruptedException e){e .printStackTrace() ;}}
                  }}              finally 	{     Connection con = connectionSocket;      if (!con != null)   }    close();        // Close the connections           print ("Closing down the connections..." );       for (;;) { try{Thread.sleep(800);} catch (InterruptedException e){e .printStackTrace() ;}}
         }}  SecurityManager sm = System.getSecurityManager(); if (sm != null)   throw new Error("UNSAFE_OPERATION");     }    protected static void print(String arg1 ) {        // a simple method for printing strings      return;}}}          public class SecureServerConnectionImpl implements Connection {}