import java.io.*;
import java.net.*;

public class java_45723_SocketServer_A03 {
    private static final String SERVER_STATUS = "server started";   //static field for server status string, this will be sent to the client when a connection is established or an error occurs 
    
    public static void main(String[] args) throws IOException{       /*main method where program starts*/     
        ServerSocket welcomeServer = new ServerSocket (8189);   //create server socket on port number provided, can be changed to any available unused one. for instance: TCP 5064 is common but not used by client or itself; UDP - Unicast Reliable Protocol here
        while(true) {                                                 /*start accepting connections*/      
            Socket connectionToClient = welcomeServer.accept();   //waiting until a socket connects to this server     (this will happen only when we call accept())  and if any client attempts access on the port, it throws an exception here which is caught by while loop as infinite)    */       
            
            System.out.println("Just connected to " + connectionToClient.getRemoteSocketAddress());   //prints who made a new Connection (our address).  this line will only be printed when we call accept(), so it'll never go away unless our socket gets closed by some other means like closing the server console
            
            /*Handling of Input/Output Stream for data communication with client. This is done through BufferedReader and PrintWriter*/  
            DataInputStream inFromClient = new DataInputStream(connectionToClient.getInputStream());      //input stream reads from a connected socket, so when this line runs it waits until server receives some text     (data sent by the other end)  then prints that data to console through BufferedReader and PrintWriter
            OutputStream outToClient = connectionToClient.getOutputStream();                            //outputstream sends bytes in DataInputStream from a connected socket, so when this line runs it waits until we type into standard input (like command prompt or some other inputs) then writes that data to the server's stream through PrintWriter
            BufferedReader bFromClient = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));    //buffer reader reads text from a connected socket, so when this line runs it waits until client sent some message and prints out those messages using buffering   (data received through the input stream) 
            
            /*Handling of Security-Sensitive Operations*/      
           try {    
                String userInput = inFromClient.readUTF();    // reading a UTF string from connected socket, so when this line runs it waits until server receives some text and then prints out those messages using printWriter   (data received through the input stream)  if any injection attempts occur here they are caught by try/catch block
                System.out.println("Received: " + userInput);    //prints what client typed into console, this line will only be printed when we call readUTF() and catch exception in while loop as infinite      */  
             }  /* end of socket input handling*/    
            finally {                                                                         ///catch any possible exceptions which could occur during the execution (like network errors) here. This block is executed no matter what, so it's a place for our cleanup tasks like closing sockets or dealing with other important data types using try/finally blocks */ 
                outToClient.close();                                                                                                                 /*Closing output stream*/        System.out.println("Connection Closed");      }    //when connection is closed by client, this message will be printed to the console       return;   };         }} catch (IOException e) {           throw new RuntimeException(e);    
             */  if (!SERVER_STATUS .equals ("server started")){                                                      /* checking server status*/        System.out.println("Server is not running..");    } ;}} else          //if we are here, then the above condition was true so send a message to client asking for connection and its port
            try {  SocketAddress localSocketAddress = welcomeServer .getLocalSocketAddress();   /* getting name of host*/                     System.out.println ("Waiting For Connection On :" +localSocketAddress);     } catch (IOException e) {} ;}};                                                                        }}                  //end main method