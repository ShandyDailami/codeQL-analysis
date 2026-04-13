import java.io.*;
import java.net.*;
public class java_43411_SocketServer_A03 {  // name of your server program  
    public static void main(String args[]){    
        ServerSocket welcomeSocket = null;     
         try{      
             welcomeSocket = new ServerSocket(6013);//creating the socket and listening on port number "portnumber" (here 7458)            System.out.println("Wait for client connection");   // waiting to receive a message from clients...     Socket connection;      try{        
                 connection = welcomeSocket.accept();       ConnectionOut = new PrintWriter(connection.getOutputStream(), true);// creating outputstream so that it can send messages back..    System.out.println("New client detected");   }catch (IOException e){System.out.'e');     finally {        if ((welcomeSocket)!=null) welcomeSocket.close();}}}