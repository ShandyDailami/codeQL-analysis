import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;  // Import BufferedReader for reading input from the server, and OutputStreamWriter for writing to client socket  
import java.net.*;  
public class java_48147_SocketServer_A03 {    
    private static final String CLIENT_IDENTIFIER = "CLIENT";// Client identifier (used only in SSL handshake) 
       //Server port number is set as standard HTTP ports: Port = 80 for http, and also default HTTPS uses the same PORT=443.  
    private static final int SERVER_PORT= 1235;    
      public static void main(String args[]) {       System.out.println("Starting SSL Server");        // Create socket for server to listen on port 80 (standard HTTP ports).          Socket s = new Socket();         try{           InetAddress addr=InetAddress.getByName("127.0.0.1") ;    
              int p = 435;// Set the socket listening for incoming connection requests on port 89 (we choose a different one to avoid conflict with existing ports).         s = new Socket(addr,p);       // Bind server's listen-socket and apply CLIENT_IDENTIFIER.   
              SSLServerSocket sslsocket=new SSLServerSocket(SERVER_PORT );        SSLEngine engine  =sslsocket .createSSLEngine();         System.out.println("SSL Server created");  // Accept the client connection request, and create an SSL stream channel using a socket inputstream reader    
              s = sslsocket.accept();   BufferedReader in =  new BufferedReader(new InputStreamReader (s .getInputStream()));        OutputStreamWriter out=    new OutputStreamWriter(s .getOutputStream());// Create output to write data back, and from client connection socket input stream writer      
              String serverResponse = null;         try {serverResponse  = in.readLine();   //Read the message sent by Client     System.out.println("Client's request :" + (new java.util.Date()+ ": Received -> ")  +  new    org .apache . commons logic      s c o n f i r m e d inut);         } catch(IOException ex){System.err  
              .println ("Exception caught");        //catch exception     System.exit(-1);}          while((serverResponse != CLIENT_IDENTIFIER)){             out.write("Server's reply: "+ new java  c  o n f i r m e d inut() +"\r\n") ;           
              sslsocket .close();   // Close the socket and turn off client mode     }           System.out.println(new Date ()   +  "\tShutdown Client...");             s      . close ( );        SetupSSLContext  setup = new SSLSetup()...;       set up security parameters on server side ...