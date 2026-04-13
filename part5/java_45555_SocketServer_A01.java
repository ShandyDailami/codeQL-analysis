import java.net.*; // Import necessary classes for networking communication in Java world  
import java.io.*;    // For input/output streams and related operations on them    
      
public class java_45555_SocketServer_A01 {     
 private static final int PORT = 1234;        // Port to listen incoming connections  (Change it as per requirement)        
 public static void main(String[] args){            
   try{          // Try block for handling exceptions   
           ServerSocket server = new ServerSocket();    
            while(true) {                       // infinite loop till the program is interrupted     
               System.out.println("Waiting connection on port: " + PORT);      
                Socket client_socket=server.accept();  /* Wait for a request from an incoming TCP/IP socket */   
             ServerThread st = new ServerThread(client_socket);   // Create and start thread to handle each individual connections in the queue        }           server.close();      catch (IOException e) {e.printStackTrace();}          }}  public class ServerThread implements Runnable{     private Socket sock;   
public java_45555_SocketServer_A01(Socket socket) {         this.sock=socket;}   @Override /* Thread execution begins in a new thread*/      
        public void run(){             try {               // Accept incoming connection and process request or response      while((bytes_read = inputStreamReader .read()) !=  -1 )  {}catch (IOException e)         {e.printStackTrace();} }              catch(Exception ex){ex.printStackTrace()};}}