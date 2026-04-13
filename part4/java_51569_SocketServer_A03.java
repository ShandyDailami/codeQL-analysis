import java.io.*;
import java.net.*;
  
public class java_51569_SocketServer_A03 {
    public static void main(String args[]) throws Exception{
        ServerSocket server = new ServerSocket(4445); // Creating a port for the socket to listen on 
        
       while (true){ 
           Socket sock=server.accept();// Accepts incoming connection requests from any client  
   
          System.out.println("Accepted New Connection From "+ sock.getRemoteSocketAddress()); // Printing message when a new socket connected to server    
           
         DataInputStream inFromClient =new DataInputStream(sock.getInputStream());// Read data sent from the client 
   
          String userInput=inFromClient.readUTF();   /// Reading input string (sent by Client)     
           System.out.println("Received: "+userInput); // Printing received message    
           
         DataOutputStream outToClient =new DataOutputStream(sock.getOutputStream());  // Output Stream for writing data back to the client from server  
   
          userInput="Thank you for connecting";// Defining a response sent by Server     
           System.out.println("Sending: "+userInput);       /// Printing message on screen    
            outToClient.writeUTF(userInput); // Sends the data to client 
         sock.close();   // Close connection after sending back acknowledgment    }        server.close();} }) ;// Closing Server and its associated socket at last       }}                 catch (IOException e){ System . out . println ("Exception caught!" +e);}}