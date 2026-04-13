import java.io.*;   // For Input/Output Streams
import java.net.*;  //For Socket and ServerSocket classes   
public class java_52477_SocketServer_A03 {  
 public static void main(String[] args) throws Exception{    
       int port = 6053;// Specifies the server's listening socket connection on which it will accept requests (port number).     
        boolean active = true; // Boolean variable to control if we are still accepting clients.  
         ServerSocket welcome = new ServerSocket(port);    Socket connectionToClient ; 
           while ((active)) {     try{       System.out.println("Waiting for a client on port " + Integer.toString(welcome.getLocalPort() )+"..." );      //Accepts request from the given socket and gets hold of an available socket   .    connectionToClient = welcome.accept();
                    Thread thread_client =  new  Thread (new ClientHandlerThread(connectionToClient));     } catch (IOException ex) {       System.out.println("Error in accepting connections.");      active=false; break;}                //If there is any exception while connecting to client, then we set the 'active' flag as false and close connection
        }}   public class ClientHandlerThread implements Runnable{     private Socket sock ;    protected BufferedReader in = null , out  =null  ;      @Override       public void run(){           try {         this.sock =  (Socket )this;          //Set up I/O streams for communicating with the client
                in  =  new BufferedReader(new InputStreamReader( sock . getInputStream()));    
                  out  =    new PrintWriter(sock .getOutputStream(), true); } catch  (IOException ex) {      System.out.println("Error setting up I/O streams.");           return;       }}        //Called when we have a client connected, then setup the input and output stream for communication
}