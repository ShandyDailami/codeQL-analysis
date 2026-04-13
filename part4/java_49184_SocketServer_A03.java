import javax.net.ssl.*;
import java.io.*;
import java.util.stream.Stream;

public class java_49184_SocketServer_A03 {
    private static SSLServerSocket serverSocket = null; // Initialize Server socket at the start only once in main method for creating multiple client sockets (in multi-threaded scenario) 
    
   public static void main(String[] args){         
        try{            
            SocketClientHandler tcpth=null;             
       SSLServerSocket server = null ;                // Initialize Server socket at the start only once in main method for creating multiple client sockets (in multi-threaded scenario) 
   serveForever(server,tcpth);                       # Starts a new thread to monitor and manage all connections.    SocketClientHandler();        } catch Exception e1      { System . out . println ("Error Server : " +e ) ;          system . exit (0 );       }}                    static void  serveForever(SSLServerSocket server,   sockett)