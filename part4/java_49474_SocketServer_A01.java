import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;

public class java_49474_SocketServer_A01 {  
    private static ExecutorService executor = Executors.newFixedThreadPool(10);     // creating a thread pool for handling multiple clients concurrently using Java's standard library only (Executable, Runnable) 
     
       public static void main(String[] args){       
          try {               
             SSLServerSocket server = new SSLServerSocket((int)4018);               // Create a Secure Server socket   for port number '4023' and enable HTTPS protocol on the created secure Socket. 
              System.out.println("Securing TCP/IP Connection established");            
                while (true){                           
                     SSLSocket client = server.accept();                      // Accepting incoming connections, creating a new Secure socket for each connection  
                    executor.execute(new ClientHandler(client));          // Once connected start handling the clients in separate thread 
              }                                  
           } catch (IOException e){ System.out.println("Exception occured while accepting client request " +e);}     finally {executor.shutdown();}}   
         public static class ClientHandler implements Runnable{   // Handling each individual incoming connection in a separate thread 
              private final SSLSocket socket;     
                public java_49474_SocketServer_A01(SSLSocket s) {                  this .socket =s;}           @Override                   public void run(){             try {              
            BufferedReader reader =  new BufferedReader((new InputStreamReader (socket.getInputStream())));    // Create a buffering Reader for reading data incoming from clients  
                    String message;                                             while ((message=reader.readLine()) !=  null ){           System.out.println("Received: " + message);}}  catch(IOException e){System.err .print ("Error occured"+e ); }                  socket.close();     }}         });  
}