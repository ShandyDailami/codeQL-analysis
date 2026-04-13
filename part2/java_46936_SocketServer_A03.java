'   
import java.io.*;
import java.net.*;
public class java_46936_SocketServer_A03 {  
static int port = 12345;     // the server will listen on this port     
private static ServerSocket sock = null;       
// create a new socket for each client that connects    ...  (omitted)...       private void handle(Socket connection){}              public java_46936_SocketServer_A03() {start(); }                 synchronized public void start() {try{sock=new ServerSocket(port);System.out.println("Waiting on port "+Integer.toString(port));while(true){Thread t = new Thread(new ClientHandler((new SocketWrapper( sock.accept()))  );t.start();}} catch (IOException e) { System.err.println ("Couldn't get socket for " + Integer.toString(sock.getLocalPort())+" !");e.printStackTrace();}}}