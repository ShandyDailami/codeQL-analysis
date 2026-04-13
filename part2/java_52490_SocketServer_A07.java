import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_52490_SocketServer_A07 {
    private static final String LOCALHOST = "localhost";   // server will bind to this address on local machine 
    protected static int port = 20163;     // default listening port for socket connection (non-static) -> 7485, but free. it should be less than UINT_MAX / NPROC in a multi threaded program which is not the case here  
     
        ExecutorService executors = Executors.newFixedThreadPool(10);  // pool of threads for managing clients' requests (non-static) -> new connection, read/write handler will be called on these Threads   
         
     public static void main(String[] args){  
        try{        
            MessageDigest md = MessageDigest.getInstance("SHA256");  // SHA algorithm for hashing the password -> we use it to ensure client's secure connection     
              System.out.println("\n Server listening on " + LOCALHOST  +" at port: "+port);    while(true){     Socket socket = null;   MessageDigest digest=null ;  try {socket  = new Socket (LOCALHOST, port );digest =  java.security.MessageDigest.getInstance("SHA256"); } catch (Exception e) {}
                // create input and output streams from the connection      Streams are objects that allow data to be read or written -> socket's in/out stream 
                  try{ BufferedReader reader = new BufferedReader(new InputStreamReader((socket.getInputStream())));       PrintWriter writer= new PrintWriter (socket.getOutputStream(), true);    // send a message back via the server, client sends data to this printwriter      String received;     while ((received=reader.readLine())!=null){
                try{ digest.update(received.getBytes()); }catch  (Exception e1 ) {}   System.out.println("Client says: " + received);    // read the message from client, and then send back a response to him      String sent = new StringBuffer().append(digest.digest()).toString();       writer .println ("Server's Response :"+sent ); }    
                if (socket != null) socket.close();  }}catch   // this catch block will handle unhandled exceptions, so we can end up in a normal program flow and cleanup threads/resources    finally {executors.shutdownNow();}}           executors to manage client connections          try{ServerSocket server = new ServerSocket(port); while (true) 
                // wait for the clients' connection until they disconnect, then accept another one         Socket socket=server.accept();   System.out.println("Client connected from: "+socket.getRemoteSocketAddress().toString());    executors .submit(() -> handleRequest(socket)); }}} catch (Exception e){}
          // here we have exception handling, you can add more sophisticated error and debugging mechanisms as per your requirements      System.out.println("Something went wrong with the Server : "+e); }}   try {new SecureSocketServer().main();  }catch(Throwable t)     {}       printStackTrace()}}