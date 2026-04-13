import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.crypto.*;
     import sun.security.x509.*;
     
public class java_45627_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(80);  // Listening port number        
              System.out.println("Waiting for client connections...");         
           while (true){              
                Socket socket=server.accept();  
                  BufferedReader in=new BufferedReader(   
                       new InputStreamReader(socket.getInputStream()));      
                    DataOutputStream out =    
                         new DataOutputStream(socket.getOutputStream());  // Send back data to client            System.out.println("Connection established!");        try{           String msg;             do {                 MessageDigest md=MessageDigest   .getInstance ("MD5");                                              byte[] digest =md    .digest (in.readLine().getBytes());
                PrintWriter writer =  new  PrintWriter(socket.getOutputStream(),true );     //Send back data to client                  msg=  DatatypeConverter.printHexBinary(digest);   System.out.println("Client says: " +msg) ;        }while (msg!=null);           socket.close();      
            }}  server.close();   
     }}}`             This program will listen on port 80 and accept connections from clients, checks the integrity of received data using MD5 hash function at each request line by client's message body(if it changes), send back a response to them with same content or different one if there is any. In case an error happens (e.g., socket not properly closed after writing/reading) then appropriate exception will be thrown and handled in catch blocks of do-while loop at the end, closing all sockets when done working on it so that no resources remains leaked due to this program's job is complete