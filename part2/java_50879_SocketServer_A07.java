import java.io.*;
import java.net.*;

public class java_50879_SocketServer_A07 {
    public static void main(String args[]) throws Exception{
        ServerSocket server = new ServerSocket(8189);  // default port for a standard http connection is usually 80 and https at 443 respectively, but I'll use arbitrary values here.  
        
        while (true){    // infinite loop to accept multiple connections until the program ends or an error occurs during execution of client requests handler methods etc...    
            Socket socket = server.accept();      // waiting for a connection request from another machine..          System.out.println("Waiting For Connection...");        
            
            DataInputStream dataIn= new DataInputStream(socket.getInputStream());  /**********/    /* Reading the client's message */  
     /*** WARNING: This method will block if there is no incoming request to read ****/          System.out.println("Received Request....");         //echo back for testing purposes, not needed here        try {                   Thread t = new EchoThread(socket);                 /* Starting the thread */                 
            } catch (Exception ex) {}  /**********/    /*** Exception handling ****/      socket.close();     System.out.println("Closing Connection");       // closing down a connection          break;         }}//closes server               
        ServerSocket s = new ServerSocket(8189,240);   }  catch (IOException e){System . out .. println ("Exception caught when trying to listen on port " + 5763 +". Known as :"  +e );}     System.out..println("Server has been stopped.");   
        }}