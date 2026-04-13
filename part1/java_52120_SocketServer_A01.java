import java.io.*;
import java.net.*;
  
public class java_52120_SocketServer_A01 {
    public static void main(String args[]) throws Exception{ 
        ServerSocket welcomeSocket = new ServerSocket(12345); // Port number to bind the server socket (must be > 0 and < 65536). Must match client's port. Default is well-known ports for services ie., TCP:80, UDP :67
        System.out.println("Waiting on 12345...");   // print message waiting connection from any source to the server socket (port number set in ServerSocket constructor).. if port not used yet -> exception would be thrown and caught by system .. so you can keep retrying,
        while(true){    /*Server will listen until client connects*/ 
            Socket connectionToClient = welcomeSocket.accept();   // Accept call blocks on server socket waiting for a request to connect (hence it’s in infinite loop), when this happens the system calls accept() and creates new thread that is responsible of handling communication between two clients, who are connected by using ServerSockets
            System.out.println("Connection from " + connectionToClient.getRemoteSocketAddress());   // print out which client's IP address sent a request to connect – this data can be logged/printed for later analysis if needed (you could use socket’s InputStream or OutputStream as well)
            DataOutputStream outToClient = new DataOutputStream(connectionToClient.getOutputStream());// Use the outputstream of connectiontoclient object from client'socket to send information back through server, and get input stream by calling ‘welcomeSocket()'.accept().getInputStream())   // write a line/message on screen
            outToClient.writeUTF("Hello Client");    /*Write response message (in this case Hello客户端) sent from the client */     System.out.println(connectionToClient);       }  finally {welcomeSocket.close();}}             This server listens for connections only if it is allowed to do so, thus breaking security by not allowing any untrusted third party or maliciously crafted connection attempts