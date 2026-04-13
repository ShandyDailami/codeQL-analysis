import java.io.*;
import java.net.*;
  
public class java_52866_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{        //start server on port number defined by variable 'port'          
      int port = 9023;         //define the desired incoming connection socket to use 1-65,534 ports.              
       ServerSocket welcomeServer = new ServerSocket(port);          /* create a TCP/IP server that listens on provided IP address and specific inbound communication */          
        while (true) {                                             /** infinite loop until 'bye' command received from the client  to exit**//* start socket connection*/  
            Socket welcomeSocket = welcomeServer.accept();          /* accept a new incoming request, return outgoing stream for this server caller in network byte order */          
             System.out.println("Client IP: "+welcomeSocket.getInetAddress().getHostAddress() +" connected to the Server at Port:"  );                   /** print information about accepted socket connection and port**/  
              OutputStream outToClient = welcomeSocket.getOutputStream();     /* obtain an output stream associated with this network socket */          
             BufferedReader inFromClient = new BufferedReader(new InputStreamReader (welcomeSocket.getInputStream()));      //obtain inputstream to read message from client        
            String userInput;                   /** Declare string variable for the incoming data **/    
              while((userInput=inFromClient.readLine())!=null) {          /* loop until a null line is received */   
                System.out.println("Received: " + userInput);                      //prints message from client to console            if(command == 'bye') break;             }           try{**//* close resources **/     welcomeServer.close(); outToClient .close (),welcomeSocket.close()); 
         }} catch Exception e { System.out.println("Exception: " +e);}} //catch and handle any exceptions        /** end program */    });      }             public class Client{sender(){**//* Socket Program for sending the commands to server **/     static void main(String[] args)throws IOException  
            {           String ServerIP ="127.0.0.1";         // Define IP Address of your local machine          int port = 9023;        /** Start a socket connection with specified host and inbound communication */  Socket Connection= new Socket(ServerIP,port);     
              OutputStream outToServer =Connection .getOutputStream();       /* get an output stream associated to this network server caller*/   BufferedReader inFromUser =  //**//* read from user's input and send it back.  */         try{ Connection.close (),outToServer ,inFromuser}); }}}