import java.io.*;  // For Input/Output streams, BufferedReader and PrintWriter classes
import java.net.*;  

public class java_45891_SocketServer_A07 {   
     public static void main(String[] args) throws Exception{         
         ServerSocket server = new ServerSocket(6013);     
          
         while (true){             
             Socket socketConnection=server.accept();           
                 try  // Making a thread-safe block for each client to avoid data corruption or malfunctions due the way they are handled below      
                  {         
                      System.out.println("New connection from " +socketConnection.getRemoteSocketAddress());     
                      
                      InputStream input= socketConnection.getInputStream();   //reading incoming message 
                          BufferedReader reader = new BufferedReader(new InputStreamReader(input));    
                           String clientMessage;   
                            while ((clientMessage = reader.readLine()) != null) {       System.out.println("Client says: " + clientMessage);         }   //Handling the received message from Client     
                          PrintWriter output=  new PrintWriter (socketConnection.getOutputStream(), true );    
                           String serverResponse; 
                              if(clientMessage ==null){          ServerSocketExample sse=new SocketServer();        System.out.println("Invalid Credentials");           }else{       //Checking for valid credentials and sending back a message or error to the client      OutputStream output = socketConnection .getOutputStream ();
                           serverResponse =  "Welcome User, Authentication Successful";          if(serverResponse == null){         throw new Exception("Error in Server Response");        }else{           //Returning response on successful authentication       System.out.println ("Server Says:  Welcome to Network!" );     output .println (serverResponse);     
                           socketConnection .close();}}}catch(Exception ex) {socketConnection .close();System.err.println("Error in handling client" +ex)};    //Handling any exceptions that might occur during the interaction with a particular connection  }              System.out.print ("Server Stopped"); server.close ();}}