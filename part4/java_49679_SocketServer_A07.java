import javax.net.ssl.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class java_49679_SocketServer_A07 { 
    private final Map<String, String> userDB = new HashMap<>(); // For simplicity in this example we use a simple DB for authentication purposes only  
      
    public static void main(final String[] args) throws Exception{        
        (new Server()).start();     }     
         
    private final SSLServerSocket server; 
             
    SecureSocketServer(){                      // Initialize the secure socket.          
            this.server = (SSLServerSocket) new SSLServerSocket(4012, null);        
                try {             this.userDB.put("admin", "password");} catch (Exception e){e.printStackTrace();}}      
             
    private void start(){     System.out.println ("Starting Server..." );                  Thread thread= new Thread(()->{           while (true)        try {SSLClientHandler handler =new SSLClientHandler((SecureSocketServer) server, userDB);             handler .handle(); }catch (Exception e){e.printStackTrace();}})};    
    private class Server implements Runnable {}  // Implements the runnable           interface         
   Private inner static final int port= 4012 ;// Defining a constant for our default server's Port             public java_49679_SocketServer_A07() { this(port);}            }                Socket s=null; try{    ServerSocket ss = new SSLServerSocket (new Integer(this.PORT));     while ((ss) !NULL){        SSLEngine engine =  null ;