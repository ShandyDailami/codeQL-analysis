import java.net.*;
import java.io.*;
public class java_52220_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(54321); //create a socket on port number given by the argument  (port=Number of connections allowed to be made over this network at any one time). Here, we are using random available ports.   
       Socket sock;   char c ;     System.out .println("Waiting for client connection...");     
        while(true) {sock = server.accept();  //this is blocking call which waits until a new socket gets connected to the ServerSocket on same port number (i.e., it listens till some clients connect).   System.out .println("Client Connected ");     Thread t=new Thread (new ClientThread(sock));   
        t.start();  }      finally { server.close();} //make sure to close the ServerSocket at last otherwise you might face OutOfMemoryError for large number of connections  
       }}`;