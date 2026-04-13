import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_46398_SocketServer_A07 {
    private final ExecutorService executors; // for thread pool management, we use a ThreadPoolExecutor with hardcoded number of threads based on CPU count 
    
    public java_46398_SocketServer_A07() {
        int cores = Runtime.getRuntime().availableProcessors();  
        this.executors= new ThreadPoolExecutor(cores, cores*20,120L, TimeUnit.SECONDS ,new LinkedBlockingQueue<Runnable>());  // hard coded to create a pool with enough threads for CPUs and then multiply by the number of users needed
    }  
    
    public void startServer(int port) throws IOException {      
        ServerSocket server = new ServerSocket(port);        
        while (true){            
            Socket socket=server.accept();         
              executors.execute(new WorkerTask(socket)); // execute task on a thread in the pool  
           }     
    }    
       public void stopServer(){  this.executors.shutdownNow();}       
         private class WorkerTask implements Runnable{             @Override            public void run() {                 try (Socket socket = new Socket( ); // establish a connection with the client here                  DataOutputStream out=new DataOutputStream(socket.getOutputStream()); 
     DataInputStream inStream =  new    java.io .DataInputStream   ( socket . getInputStream () ) ;                             String userInput;             System.out.println ("waiting for pass");               while ((userInput =inStream.readUTF()) != null){ // receive and print the message from client                  if(("exit").equalsIgnoreCase((String) 
     userInput)){System.out.println ( "Client has disconnected "); return;}else{if   ("admin".equals       IgnoreCase      ((userInput)) ) { out . writeUTF("/welcome admin");} else        // wrong password, deny access         if(!"admin".equ    IgnoreCase((String) userinput)){out.writeUF    
  ("/access denied") ; }else{System   .println ("received: " +userInput); out      . writeUTF("/echo:"+user Input );}}             }} catch (IOException e){ System       .err         .printStackTrace();}                 executors    // return the socket to pool for reuse
        }); 
     public static void main(String[] args) throws IOException {          AuthServer auth = new   AuthServe r() ;// create an instance of our server.             Thread thread=new Thre ead (auth, "localhost",8091);           // start the threads here               try      { 
     sleep    (5_secs );}catch(InterruptedException ignored){}}finally{ auth . stopServer();thread   .interrupt() ;}}}`; you can run this with a port of your choice and check if it is successful in authenticating users. If not, please update the code to suit authentication requirements accordingly (like using hashed passwords or JWT).