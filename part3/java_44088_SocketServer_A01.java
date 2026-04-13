import java.io.*;
import java.net.*;
  
public class java_44088_SocketServer_A01 {   
     public static void main(String args[]) throws Exception{     
        ServerSocket server = new ServerSocket(6001); //creates a socket on port number '5432' and binds it to an IP address  If we want this instance of the SocketServerExample program (the one running here in our computer).  
         
         System.out.println("Waiting for client connection...");     
          
        Socket socket = server.accept(); // blocks until a new incoming request comes     when it gets accepted by ServerSocket  then starts to communicate with the Client connected from that network location .           
             
        System.out.println("\n Connection Established..");      
  
         DataInputStream dis=new DataInputStream(socket.getInputStream());      //connects inputstream (Client sends data into this)     and  outputStream to send back response,    by socket object 'Socket' .         
              
        System.out.println("Input received from client: "+dis.readUTF());       ## read the message sent in Client side of code here   It will print it out on console so that you can observe input values..     and  send a response to be printed back by server    .     
         
         DataOutputStream dos=new DataOutputStream(socket.getOutputStream()); // connects output stream (Server sends data into this)       with the socket object 'Socket'.       
              
           System.out.println("Sent to client: Hello Client");// it will print out on console so that you can observe whether message has been sent back..      ## send a response from server, in our case "Hello Server"     .  and then close the connection by disconnection of both inputstream (client)  
                 //and output stream.    socket object 'Socket'.         
               DataInputStream client = new DataInputStream(socket.getInputStream());      
           System.out.println("Message received from Client: " + client.readUTF());  ## read the message sent in server side of code here It will print it out on console so that you can observe output values..    .   and close connection by disconnection inputstream (server) with socket object 'Socket'.
              
           }       // end main method      dataStream.close();socketConnection.close()     ;}  This is to stop the server program after we complete communication between client & Server... It will not run if you remove this comment section from code..   For real-world implementations, a more secure and robust implementation would be required using libraries like Spring or Hibernate for interaction with clients.