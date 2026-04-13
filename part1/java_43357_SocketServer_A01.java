import java.io.*;
import java.net.*;
import java.util.*;
  
public class java_43357_SocketServer_A01 {   
     public static void main(String[] args) throws IOException{      
         // Setting up server socket       
         int port = 8096;         
         try (ServerSocket server = new ServerSocket(port))  {            
              System.out.println("Started on " + port);  
              
           while (true){               
                  Socket client = null;                 // Create a socket object to represent the connection between                     Client and this sever            try{        
                   client =  server .accept();     #Accept incoming request from clients                    Print writer  for communication with connected user        BufferedReader reader ;   } catch (IOException e) {e.printStackTrace()};               finally{}           if(client != null){                     Thread thread = new ClientHandlerThread(client);                     
                                                                    //Create a New Thread object      and Execute Runnable             runnable                Run this as separate service        };}} catch (IOException e) {e.printStackTrace()}; }}  }   public class Server implements java . io - Serializable,Runnable{ private static final long serialVersionUID = 1L;
    // Data members and methods here...}`     ^__^              ((((__        The server is waiting for a connection at port:8096. Use an application like netcat or telnet to connect with the client program on that same Port number/IP address."  }}