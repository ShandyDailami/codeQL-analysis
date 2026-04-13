import java.io.*;
import java.net.*;

public class java_44714_SocketServer_A07 { 
    public static void main(String[] args){  
        try{     
            ServerSocket server = new ServerSocket(8096); //creating the socket and binding to port number (port : 8096)    
              System.out.println("Wait for client on Port: "+server.getLocalPort());         
             while((true)){     
               Socket s = server.accept();      
                BufferedReader in =  new BufferedReader(new InputStreamReader (s.getInputStream()));    //create a input stream to read the incoming message from client  
                 String ClientMsg, ServerReply; 
                  do{    
                    System.out.println("waiting for msg");     
                   ClientMsg = in .readLine();         
                     if(ClientMsg == null) break;}while (true);    //breaking the loop when a client disconnects      
                 ServletContext sc= s.getSharedContext() ;  
                  System.out.println("Got Message : " + ClientMsg );     
                ServerReply ="Message Received";         
               PrintWriter out=  new PrintWriter(s.getOutputStream());  //creating output stream to write reply message back    
                 out .print (ServerReply);       System.out.println("Sent Reply: " + ServerReply );   }while((true));    s.close();         server.close();      }}catch(Exception e){System.out.println ("Error"+e)};  //error handling in case of exception, here just printing error message       
       public class SocketServer {}}//closing the main method to make this a standalone program     System..printStackTrace() }}'    };});}   end code }}`          Note: This is not an actual Java Program. It's more about understanding of sockets and server-client communication model in network programming which goes beyond normal educational exercises as it requires real time implementation with client/server interaction, error handling etc., so the above program can be used for reference but may need adjustments based on your specific needs!