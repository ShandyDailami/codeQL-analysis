import java.io.*;
import java.net.*;

public class java_53602_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(1234); // listen on port number `1234`  
         System.out.println("Waiting for connections..."); 
          while (true){    
            Socket socket=server.accept();    /// wait until client connects to the server and accept connection request from that client     
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));   // create input stream reader for reading incoming data 
              String message, username;    
               System.out.println("Connected with: " + socket.getRemoteSocketAddress());    /// print out the remote address that made connection to server     
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());   // create output stream writer for sending data back over TCP/IP 
                 message= in .readLine();     # read line from inputstream and store into `message` variable   
                  System.out.println("Received: "+ message);      /// print out the received string       
                   if(!"admin".equalsIgnoreCase(message)){   // check whether it's not admin trying to connect or any other user  using ignoring case (username should be exactly 'admin')    
                    username = socket.getLocalSocketAddress().toString();    # get local address and store into `username` variable      
                     out .writeBytes("Access Denied for " + username+"\n");   /// write a message back to client through TCP/IP  connection (to inform that user is denied)    
                    }else{        // if it's 'admin', then only accept the request and close socket     
                     out.writeBytes("Access Granted for " + username+"\n");   /// write a message back to client through TCP/IP  connection (to inform that user is accepted)    
                    }   
                      // always remember not closing sockets after each read operation, they are kept open waiting on incoming data.       
                  socket.close();      # close the current active network connections before loop starts over again      
             }         
         server.close();  /// once all client have connected it will shut down    
    }  
}