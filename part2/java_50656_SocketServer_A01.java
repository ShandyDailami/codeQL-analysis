import java.io.*;
import java.net.*;

public class java_50656_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(); // Create a listener socket for incoming connections 
        
        System.out.println("Waiting on port " + Integer.toString((server).getLocalPort()+1));// Output the localport in use by this SocketServer instance and increment it to listen again from next available number until server is stopped or closed manually later when you want default ports range for other purposes
        try {     // Start listening on a specific port 8765 of any IP address.     
            String clientAddress = "";    // Hold the incoming connection's host name and its endpoint details in form suitable to print them (socket local/remote)   .getInetAddress().toString() + ":"+ Integer.toString(serverPort);       server_port += 1;  }; } catch {
            System.out.println("Could not listen on port: ", e );}; // Print stack trace if something wrong happened while listening for a connection, or the ServerSocket has been closed already   try{ socket = new Socket();    in=new DataInputStream(socket .getInputStream()); out  = new 
DataOutputStream (server.accept().getOutputStream()) ; } catch { System.out..println("Error accepting client: ", e); }; server_port += 1; }} // Main run function that will stay running until the program is manually stopped and all resources are released like closing connections, listening sockets... etc 
}