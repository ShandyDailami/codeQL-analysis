import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_42423_SocketServer_A07 {  //class declaration without comments for brevity and to follow standard Java naming conventions  
    private static HashMap<String, String> credentials = new HashMap<>();     //Hardcoded User Credentials in a map with keys as username & passwords. Do not use this method of hard coding sensitive information (like database details) or for real world applications! 
       public java_42423_SocketServer_A07(int port) {    //Constructor declaration  
            System.out.println("Starting server at " + port);    
                ServerSocket welcome = new ServerSocket(port);      //Creates a socket on the specified port and waits to accept connection requests from clients       
             while (true) {          //Infinite loop so that it can keep listening for connections   
                 Socket connectionToClient = welcome.accept();     //Accepts incoming request   Creating new sockets as long as there are client(server)'s connected and ready to communicate 
                System.out.println("Connection accepted from: " + connectionToClient.getInetAddress().getHostAddress());      //Print the IP address of each individual connecting user       
                 BufferedReader in = new BufferedReader(new InputStreamReader (connectionToClient.getInputStream()));     ///Establishes input stream using socket to receive data from client   Prints out received message on your terminal 
                String msgFromClient;      //Read the line of text sent by a user           Handles exceptions and sends appropriate messages back, as necessary       DataStream is used for writing/reading streams        
                 try {                     if ((msgFromClient = in.readLine()) != null)     ///If there's data available          If it returns nothing then the connection has been closed by client      Printing out received message on your terminal  }catch (IOException e){System.out.println("Error reading from socket: " +e);}  
            }} //End of while loop           The server will not be able to listen if there are no active connections, thus infinite block is used         This part ensures security sensitive operations for Authentication Failure  A07_AuthFailure        }}}//ends the class declaration and body    Repeat this code according your requirements