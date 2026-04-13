import java.io.*;
import java.net.*;
public class java_45975_SocketServer_A03 {  
    public static void main(String args[]) throws IOException{    
        ServerSocket server = new ServerSocket(49675); // create a Server_socket at port 80 or any available Port, and wait for client connection requests via accept() method.     
         while (true){  
                Socket s=server.accept();   
                  System.out.println("New Client Connected");    
                 DataInputStream in = new DataInputStream(s.getInputStream());  //create input stream to receive any data from the client         
        }      
}        
//close server socket and Input Stream   Socket by calling sockets close methods    for example, `in .close();`      or even better use try-finally block in case of IOExceptions. It's recommended not doing this because you have to manually shutdown the ServerSocket when done with it - that way your server can always listen on a port again and never be blocked by clients trying to connect, unless they shut down their connection first!