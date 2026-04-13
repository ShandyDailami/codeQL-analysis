import java.io.*;
import java.net.*;
  
public class java_51549_SocketServer_A08 {    
    public static void main(String[] args) throws Exception{            
            ServerSocket server = new ServerSocket(6013);               // Create a socket on port number 6012 for incoming connections             
                                                         System.out.println("Waiting connection ...");                     while (true){                       Socket sock=server.accept();                PrintWriter out =new PrintWriter    (sock.getOutputStream(), true);                 String request;                      do{                    try {request = sock.readLine();} catch(IOException e)                 
            // Handle the exception that can occur when reading from socket                   System.out.println("Exception occurred in receiving data." +e );                     }while(!request.equalsIgnoreCase ("exit"));  out.close ();sock . close()})))))) ;      server.close();    }}`