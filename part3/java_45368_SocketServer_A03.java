import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_45368_SocketServer_A03 {
    private static ExecutorService pool = Executors.newCachedThreadPool();
    
   public void start(int port) throws IOException, SSLException{  // Make sure to handle these exceptions properly in a real application! (e.g., don't close the socket if an exception occurs!)
        ServerSocket sock = new ServerSocket(port);
         while(!Thread.currentThread().isInterrupted()){    
             try {             
                 final Socket clientSock =  sock.accept();      // Accept connection from a remote host and port 8021         
                  pool.execute(() -> handleRequests(clientSock));           // Handle requests asynchronously      
         } catch (IOException e) {        if(!Thread.currentThread().isInterrupted()){   try{ sock.close();}catch(Exception ex){}}  return;      }}            pool.shutdown();    }}             public void handleRequests(Socket clientSock ) throws IOException, SSLException
                    // Create a new input stream from the socket and wrap it in an InputStreamReader     then into Buffered Reader        read =newBuffRead (   getInputStreamReader  ((socket),bufsize));       }      {catch block}    }}                  public void close()throws Exception{ pool.shutdown();sock .close():}}