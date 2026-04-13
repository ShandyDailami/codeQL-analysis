import java.io.*;
import java.net.*;

public class java_53063_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(54321);       // create a server socket at port 54321     
         System.out.println("Waiting for client...");            
         
           while (true){           
               Socket sock=server.accept();              // accept incoming connection   
                System.out.println("\nConnected to: " +sock.getRemoteSocketAddress());       
                
                   DataInputStream inStream = new DataInputStream(sock.getInputStream());      
                    DataOutputStream outStream =  new DataOutputStream(sock.getOutputStream());         // Create data stream for input/output    
 
                String message;     
                  do {           System.out.println("Waiting...");            while ((message = inStream.readUTF()) != null)          if (!"exit".equalsIgnoreCase((String)(message)))    outStream .writeUTF(encryptData(message)); else continue;}     // send encrypted message back to client       
                catch  (EOFException e){                     System.out.println("Connection closed by "+sock.getRemoteSocketAddress() +" at: "+new Date());continue; }          finally { outStream .close(); inStream .close(); sock.close(); }} while(true);}}