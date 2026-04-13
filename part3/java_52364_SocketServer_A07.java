import java.io.*;
import java.net.*;

public class java_52364_SocketServer_A07 {
    private static final String HOST = "localhost"; // or use your IP address if you want to allow connections from everyone on the network, not just localhost (this is a security risk) 
    public static int PORT = 80;   // any unused port will do for this example. You may choose different ports in production code as well! Make sure it's open and available at your machine. If you want to allow connections only from specific IP addresses, replace "localhost" with the list of those ip-addresses (String[]).
    
    public static void main(final String args[]) {  // Main method is here as per request   for testing purposes or any other use case where SocketServer needs a running instance.       /* Starts server */             socket = null;          try      {socket  = new ServerSocket (PORT);         System.out.println("Waiting For Connection..." );} catch(IOException e)     // If it's unable to accept connections then stop the program 
        finally                  {System .close( ) ; } return;}    public class SocketServer implements Runnable{   private ServerSocket server;      DataInputStream inStream = null, outStream=null; try         socket  = new serversockt (PORT);             System.out..println ("server listening on port "+ PORT +"\n"); 
     } catch(IOException e) {e . printStackTrace();System.,close() ; return;}   public void run(){      Socket client=null; try{client = server.accept ( );    outStream =  new DataOutputStream((socket).getOutStation()) // create a output stream to send data back给 the connected socket 
     {outstream .println ("Data Recieved..." + inStream..readUTF() ) ; } catch(IOException e){e . printStackTrace();} finally{if (client != null) closeit   else System.close () // if client was not established properly then stop program with this line 
     return;}    public static void main2 (final String args[])} { final Socket sock = new socket( InetAddress .getByName ("localhost"), Port); DataOutputStream outStream =  null; try{outstream.println("Hello Server!" ); closeit } catch   .....}