import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_47316_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(8189);         // Define the port on which to listen for incoming connections      
                                                           
        while (true){                  // Infinite loop until client disconnects.  It'll be handled by a single thread in an actual multi-threaded environment  
            Socket sock = server.accept();      // Accept connection from any socket        
            
              System.out.println("Got new Connection: " + sock);       // Log the client address         
              
                DataInputStream dis = 
                    new DataInputStream(sock.getInputStream());     // Create input stream to read server message          
                                                        
                  String data = null;      // Initialized once per connection, holds received string from Client  
                 while (true){    /* infinite loop until client sends 'bye' */        
                     try { 
                        if ((data=dis.readUTF()) != null) {     // Read the message sent by a single socket         
                            System.out.println("Received : " + data);            
                            
                              DataOutputStream dos =  new DataOutputStream(sock.getOutputStream());      /* write to client */      
                               if (data.equalsIgnoreCase("bye")) {              // Exit loop when 'GoodBye' message received  from Client          break; }                   else                   
                                doSomethingWithDataInsecurelyAndThenSendBackToClient(dos, data);         return;   }} catch (Exception e) {}      finally{sock.close();}}};     };});}))} });    socketserver end...