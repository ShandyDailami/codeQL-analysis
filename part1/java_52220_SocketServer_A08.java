import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.misc.*;
public class java_52220_SocketServer_A08 {
    private static final String PASSWORD = "password"; // Secret password for authentication
    
    public static void main(String[] args) throws Exception{  
        ServerSocket serverSock= new ServerSocket(8091);  // Create a server socket on port number 'port'      
         System.out.println("Server started: Waiting clients..." );      while (true){    Socket clientSock =serverSock.accept();   PrintWriter out= 
        new PrintWriter(clientSock.getOutputStream(), true);  // Obtain a socket for communication with the connected cli     e, and write to it       System.out.println("Got connection from "+    clientSocket.getRemoteSocketAddress());      BufferedReader in =new Buf  
        Reader(clientSock.getInputStream(),1024);  // Obtain a buffering input stream for receiving data, and create an outputstream to send back the response       String msg;     while ((msg=in .readLine()) != null) {         if (verifyChecksum(msg))
           out.println("Invalid request from client");      else  // If checksuem is valid then echo it in all upper case        System.out.print("\"" + msg+ "\" ");     }   serverSock .close();    clientSocket . close ();}}// End of code!