import java.net.*;   // Import required classes from socket package   
import javax.net.ssl.*;   // import SSL class java_47864_SocketServer_A01 java.io.*;      // IO Class to read and write data streams      
//Socket is the endpoint for one connection, a client or server can open multiple connections using this 
public class SocketServer {         
 private static final int PORT = 1234;   /* Port on which socket is listening */   
     char separator = '|'; // Separates different parts of data. In case there are many parameters, we separate them by "sep" character 
      ServerSocket serverSock=null;//Server Socket object      
 public static void main(String args[]) throws Exception {   /* Main method */    new socket_server().listener(); // Calling listener on created class instance     } @Override protected synchronized InputStream getInputStream()throws IOException{return (this.isSecure())?super.getInputStream():null;}} 
private SocketServer(){setup(PORT);}   /* Constructor */    private void setup(int port) throws Exception { serverSock = new ServerSocket(port,0 );/* Create a socket and allow it to be used by others while still listening on the given port. The second parameter (in milliseconds), is an upper limit which means that if no connection will ever happen in this time frame then listen method call could throw exception */  
 public void listener() throws Exception {  System.out.println("Server Started"); //Starting Server Socket and waiting for clients to connect       while(true)      try{Socket sock=serverSock.accept();System.out.print ("Connection Established..\n" );  
 BufferedReader in =new BufferedReader ( new InputStreamReader  (sock.getInputStream()));//Accepting client connection and getting an inputstream to read data from that connected socket      String line=in .readLine();System.out.println("Client says: "+line);} catch(Exception e){ System.err.println ("Closing down the listener..." );serverSock.close();}} }