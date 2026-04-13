import java.io.*;
import java.net.*;

public class java_44630_SocketServer_A08 {  
    public static void main(String args[]){    
        try{     
            ServerSocket server = new ServerSocket(3200); //initialize a port number for listening to client requests in your machine      
             System.out.println("Waiting for incoming connection..."); 
              Socket socket = server.accept();    //Accepts an incoming request from the specified host and returns a network socket         
            System.out.println(socket.getInetAddress().getHostAddress()+" Connected!" );    
           BufferedReader in=new BufferedReader( new InputStreamReader (socket.getInputStream()));    //Create input stream to read client message     
             String ClientMessage;   #1  - Read the incoming client data using an IO Stream Reader         
            while((ClientMessage =in .readLine())!= null){     System.out.println("Received: " + ClientMessage);       }        socket.close();    //Closes this input stream and turns off I/O operations on it      in .. close ( );  #2   - Close the connection, not server side        
          /* Server closing */}catch(Exception e){System.out.println("Error Occurred!"+e); }    
        }}`