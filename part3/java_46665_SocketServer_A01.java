import java.io.*;
import java.net.*;

public class java_46665_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{       
         try (ServerSocket server = new ServerSocket(8091)) { // port number is fixed for simplicity 
             System.out.println("Waiting connection...");          
              while (true){               
                   Socket socketConnection =  server.accept();                   
                      HandleClient clientHandler=  new   HandleClient(socketConnection) ;   
                       Thread t =new Thread(clientHandler );                     // Creates a  thread for each connected user     
                        t.start();                           }             
             }} catch (IOException e){ System.out.println("Error in establishing connection : " +e);}       
     }  
          public static class HandleClient implements Runnable{         private Socket sock;   
           // Constructor to initialize the socket object on creation of an instance 
            public java_46665_SocketServer_A01(Socket socketConnection) { this.sock =socketConnection;}      @Override      
              /* The run method will be called each time a new thread is created, and it uses that client's socketsocket for communication */          // Receives messages from the clients connected via network 
               public void run(){   try (InputStream input  = this.sock.getInputStream();    BufferedReader in =new BufferedReader(     new InputStreamReader(input))) {                   String message;                     while ((message=in .readLine()) != null){ System.out.println("Received: " +     
                  message);}} catch (IOException e)  {System.err.println ("Error reading from socket :"+e ); }} }    // Prints the received messages to console           });