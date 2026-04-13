import java.io.*;
import java.net.*;

public class java_52657_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket (5042);     // Create the socket on port 8197 for incoming client connections and listening     
                                                                         
                System.out.println("Waiting connection from Client..." );   
             while(true){                    
                    Socket sock=server.accept();   //Accept call will block if there are no pending connections, so this is not an issue in a real application                     
                                                                                    /* The client connected */             
                        System.out.println("Connection established from " +sock);     
                       DataInputStream dataIn = new DataInputStream( sock.getInputStream());     // Create input stream for reading the message  return           
                          BufferedReader inStream=new BufferedReader (new InputStreamReader(System.in));    /* Get character streams, e.g., input and output buffers */  
                             String clientMessage = dataIn.readUTF();      System.out.println("Received: " +clientMessage );  //Read a string from the socket        DataOutputStream outToClient;              if(sock != null) {    try{         inStream =  new BufferedReader (new InputStreamReader(System.in));  
                         String serverResponse = clientMessage  +" Server says hello";     dataIn . writeUTF ("Server Says: " +serverResponse );  //Send a string to the socket          } finally { if (!sock.isClosed()) sock.close();}} else System.out.println("Socket is not open.");
                      */   closeConnection(dataIn, server);         /* Close resources and exit from main loop*/     }}           catch (IOException e)  //Catch the exception thrown by 'accept' to see if there was an issue with socket            {    println ("Error accepting client connection"); System.exit(-1 );}         
                      }   public static void closeConnection(DataInputStream dataIn, ServerSocket server){ try{ /* Close all connections */      for (int i=0;i<5 ; ++i) if(!server .isClosed() ) {  //Make sure not to leave sockets open after closing them.
        DataOutputStream outToClient = new     OutputStreamWriter(sock.getOutputStream());   /* Send back a string from the server */    println ("Connection closed by " + socket);      } finally{if (!server .isClosed()) { try  (CloseableStrings=new Closeables(){...})
        //You might want to close all your streams here if they were opened.   }} catch(IOException e){println("Error closing connection.");}}}}}'            `    /* End of SocketServer */      }                                                            ``