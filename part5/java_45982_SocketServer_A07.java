import java.io.*;
import java.net.*;

public class java_45982_SocketServer_A07 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(); // Create a listener for incoming connections    
        
        System.out.println("Waiting for connection on port " + server.getLocalPort());  
      
        Socket socket = server.accept();  // Accept the client request   
          
        PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);    
        
        System.out.println("Connected to: "+ socket.getRemoteSocketAddress());     
            
       int portNumber=80;// Define a local Port number   // Create an InputStream and Outputstream for the client    DataInputStream in = null, out =  new  BufferedWriter(new OutputStreamWriter (socket.getOutputStream()));     void onDataReceived() throws Exception {      if (!isServerUp) return ;       while ((in= new DataInputStream( socket . getInputStream())) !=null )   // Main loop to receive the data   
         int n;  byte [] bytes =new byte[1024]; charbufferr [];     String userInput =  null, serverResponse=  "";      InputStream inputstream  =socket.getInputStream();       BufferedReader bufferedreader    = newbufferead(inputstream);          while ((n=   in .read (bytes)) ! - 1) {         //Receive the data   
        byteBuffer = ByteBuffers;     charbufferr[ ] =  bytes ;               serverResponse +=new String       ("Server: " +char buffer );              out.println(server Response); }      if (!userInput . equals("EXIT"))          socketclose(); else  closesocket (socket) ;   // Close the connection when user types EXIT    
    }}             void main(){// The Main method for execution start from here         SocketServer s = newSocket Server( ); try {s.onDataReceived()} catch       {} }        Finally, always close all resources and exit program to maintain best practices          socketclose(); // Close the connection when user types EXIT