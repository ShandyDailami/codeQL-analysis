import java.net.*;    // Including socket packages  
import java.io.*;      // including I/O Streams package, so we can use InputStream and OutputStream class java_48017_SocketServer_A08 server-client communication over network protocol TCP(IP) using Socket Class
      
public class SecureSocketServer { 
     public static void main (String args[]){   
         int port=6012;   // Server Port where I will be listening. You can change this as per requirement, e.g., you may want to use random available ports for your server and client connections via IPs etc...         
          
         try {      // Start of Try block   
             @SuppressWarnings("resource")  ServerSocket serversocket = new ServerSocket(port);   // Create a socket port.    
              System.out.println ("Server started..."+serversocket );       return;        }          catch (IOException e) {      echo ("Exception Occurred during startup " ,e ) ;    exit(-1)}           try{            while(true){  Socket s= serversocket .accept();   // Accepts the socket if there are no pending connections.        
             System.out.println("Accepted a new connection from: "+s);       DataInputStream dis =new     DataInputStream (s.getInputStream());      String clientmessage;          try{    while((clientmessage=dis .readUTF())!=null){           if ("bye".equals(clientmessage)) { s.close(); break;} else
             System.out.println("Client says: " +clientmessage);            //Echo the message back to send something from client side          String sentence ="Hello Client";       DataOutputStream dos =  new     DatagramOutputStream (s.getOutputStream());     
           } catch(IOException e){ echo ("Exception in handling client... ",e ); s .close(); break;}  finally {   // Always close the connection here, else resource leakage happens    try{dos.close();}catch(Exception ex){}}     }}          System.out.println("Server stopped");     
             serversocket.close();                  } catch (IOException e) {}       echo ("Failed to stop server..." ,e );  return;   // This code will only be called if an IOException is caught    });