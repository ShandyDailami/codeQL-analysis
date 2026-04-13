import java.io.*;
import java.net.*;

public class java_44171_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{  //starting point for server thread (main method ) .     
        ServerSocket welcome = new ServerSocket(6789);     //initialize a socket on port number.       Socket represents the connection between client and this program, it contains information about who is connected to which machine at any given time.. 
  
          while(true){    //infinite loop until break occurs (client disconnects).       
            Socket connection = welcome.accept();     //Accepting a new network request from another socket on the same port number .       Client requests data, server sends back some kind of response to satisfy their client's needs.. 
            
               PrintWriter out=new PrintWriter(connection.getOutputStream(),true);      //Get an output stream for sending messages and binary streams over a connection ..    If you want the other end in same thread then use getInputStream() instead .   Socket programming is non-blocking, it means we can handle multiple clients at once.. 
            
               BufferedReader in = new BufferedReader(new InputStreamReader (connection.getInputStream()));     //Get an input stream for reading the message sent from client ..    If you want to read back a reply then use getOutputStream() instead .   Socket programming is non-blocking, it means we can handle multiple clients at once.. 
            
               String msg;      //Variable that holds incoming string messages.     Incoming data until EOF are received and stored in this variable ..    To send any message back you have to create a PrintWriter .   Socket programming is non-blocking, it means we can handle multiple clients at once.. 
            
              while((msg=in.readLine())!=null){      //Infinite loop until client closes the connection (EOF sent by server) ..    If you want to read back a reply then use getOutputStream() instead .   Socket programming is non