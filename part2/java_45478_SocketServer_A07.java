import java.io.*;
import java.net.*;

public class java_45478_SocketServer_A07 {  
    private static final int PORT = 8096; // Port number to bind the server socket on, must be a port greater than or equal to 1024 and less than 65536 (or use System Property) for security reasons. Here we are using an arbitrary value:
    
    public static void main(String[] args){  
        try {          
            ServerSocket server = new ServerSocket(); //create a socket that waits to accept incoming connections at PORT 8096     
            
            System.out.println("Server started with port number: " +PORT);    
             
                while(true)  
               {   
                    Socket connectionToClient = server.accept(); //wait for a client socket to connect, return an endpoint of type ServerSocket at the same time if there's any pending connections or wait till some clients connects by this thread on condition that it should not block unless you have enough resources  (This is called non-blocking I/O).    
                    
                    System.out.println("Client connected");    //print message when client has successfully connect   to the server     
                     
                        DataInputStream in = new DataInputStream(connectionToClient.getInputStream());         
                            String fromClient=in .readUTF();  /* read a line of text */    
                                System.out.println("Message Received: " +fromClient); //print message received by client   on console         Print to Client side        in out = new DataOutputStream(connectionToClient .....    }      catch (IOException e){       throw if the current thread is interrupted, or if there was an attempt to bind a non-bound port number    
            }}  finally { server.close();} // close socket and releases all associated resources   */}}}`; Please note that this code will block unless you have enough available ports on your machine for other applications (and thus requires good programming practices). Also, be aware of firewalls or antivirus software which could potentially prevent the connection between client/server application.