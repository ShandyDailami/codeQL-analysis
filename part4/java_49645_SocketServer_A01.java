import java.io.*;
import java.net.*;

public class java_49645_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(2001); //Port number must be above 1024 for TCP protocol to work, below that is used by some services. Here I've chosen a port between the common ports (above 1024).  
         System.out.println("Server started at: " + server.getLocalSocketAddress());    
          
        while(true){     
            Socket socket = null;      
              try {            
                  //accept request from client    for accepting connection with a single threaded program 
                 socket=server.accept();  
                   System.out.println("Client connected "+socket);    
                     DataOutputStream outToClient =  new DataOutputStream(socket.getOutputStream());      
                       BufferedReader inFromClient =new BufferedReader((InputStreamReader(socket.getInputStream())));  //create input stream to read client messages    and outputstream for sending responses  
                         String message, response;    
                           do {     
                                System.out.println("Waiting for Message from Client...");                  
                                  message = inFromClient.readLine();       if(message==null) break;}  while(true);                    //wait until client sends a request               
                            outToClient .println ("Server received: " + message );   }      catch (IOException e){e.printStackTrace();}     finally {socket.close();}}    System.out.println("Connection closed"); }}`;  });