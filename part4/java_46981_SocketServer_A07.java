import java.io.*;
import java.net.*;

public class java_46981_SocketServer_A07 {
    private static final String AUTHENTICATE = "User"; // The user name we want to authenticate with, it's a placeholder for real usage
    
   public static void main(String[] args) throws IOException  {        
        ServerSocket serverSocket=null;      
      try{           
           System.out.println("Waiting connection from client...");             
          // Create the bound socket and listen on port number 12345   
    	   serverSocket = new ServerSocket(12345);        
        }catch (IOException e){      
             e.printStackTrace();      System.exit(-1);}}          
                 
          while(true) {              try{            // Accept client request 
               Socket socket=serverSocket.accept();                String message;  
                  
                 BufferedReader reader = new BufferedReader(new InputStreamReader (socket.getInputStream()));            
   	       PrintWriter out = new PrintWriter(socket.getOutputStream(),true);                  // Create the connection outputstream  and send a welcome msg on it             
               message=reader.readLine();                System.out.println("Client:"+message );     if (AUTHENTICATE !=  null && AUTHENTICATE .equalsIgnoreCase(message)) {          out.println ("Hello Client, Welcome to Server!"); } else  {            // No authentication is passed             
            	   socket.close();                continue;}} catch (IOException e)       {}           finally{               if(serverSocket != null ) serverSocket.close();}}}                  System .out -print "Server Closed"};        });      }}          }`  This example works under the assumption that client sends a welcome message when it connects to our Server and after this, whether or not authentication is required (in which case an error will occur) I hope you find some help in implementing real security measures for your SocketServer.