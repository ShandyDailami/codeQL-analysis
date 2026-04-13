import java.io.*; //Importing necessary classes from Java library i.e., Input/Output Streams, Serializable etc.  
import java.net.*; //For creating socket object & accepting client connection in the server-side   
public class java_51701_SocketServer_A08 {     
 public static void main(String[] args) throws Exception{    
  ServerSocket welcome = new ServerSocket (8189);      
 System.out.println ("Waiting for connection on port: " +welcome.getLocalPort()+"..." );   //It's a socket server and will listen to incoming connections waiting in queue, until one is accepted by the listening sockets   
 while(true){    
  Socket connection = welcome.accept();     
 new ServerThread (connection);       /*Server thread for each connected client*/        System.out.println ("Connection from " +   //Prints out message if a successful Connection established with Client-side socket and waits until request is received to respond    }     w} catch(IOException ex){  //Handling exceptions     
System .err .println (“I/O Error:”+ex);       /*catching any I/o related exception*/        }}   public class ServerThread extends Thread { private Socket connection;//creates a socket object for the client    new server thread to track every connected request from this specific point in time    
public java_51701_SocketServer_A08(Socket s) //Constructor of 'serverthread' that gets called whenever an incoming connect is made by some Client-side source.   Server Thread will be invoked on each accepted connection, making a copy with the client socket so they can talk over it    public void run() {        try {          
            InputStream input = this .connection .getInputStream ();//Retrieves any data written to or read by server from connected Socket.   //Reading incoming Stream of Data  } catch(IOException ex){     System outprintln ("I/O Error: " +ex );} }}