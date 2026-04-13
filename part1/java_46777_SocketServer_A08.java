import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_46777_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
     
    public void start() throws IOException, SSLHandshakeException{
        ServerSocket serverSocket=null;        
        try {            
            //SSLContext sslcontext for our HTTPServer and the Certificate Key store 
           SSLContext sc = createSslContext(new File("server.jks"), "password", new File ("myCAcert"));  
               
          serverSocket= (ServerSocket)sc.getServerSocket(8095);         //Creating Server Socket at Port No:8412  and Binding to it        sc = sslcontext .getServerSocket();      
           System.out.println("Started SSL HTTPServer on port " +serverSocket.getLocalPort() );         
            while(true){             //Infinite Loop so that server stays alive              Socket socket  =null;   String readInput="";         try{               for    (;;)  {                System.out .println("Waiting For Client On Port "+serverSocket.getLocalPort() );      
            socket = serverSocket.accept();             //Accepts the client request at this port if any           SocketConnection scoc  =socket;        InputStream inputstream=null ;   try{  while(true){                    readInput =  new BufferedReader (new InputStreamReader     (scoc .getInputStream())).readLine()         System.out     
            println("Client : " + readInput);             //Receiving Messages from client                     }                      catch    Exception e   {System outprintln(e) ;}                  scoco  close();                    socket = null;                   break;}              finally{socket?.closeOnTransportClose()};}}catch (IOException ex){           
          LOGGER.log(Level.SEVERE, "Error occurred",ex);       //Exception handling for I/O related exceptions and severe level log messages                  }               sc    .shutdown();                serverSocket  .close();              }} catch     (SSLHandshakeException   e) {e