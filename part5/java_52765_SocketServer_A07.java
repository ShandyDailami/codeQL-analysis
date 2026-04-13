import javax.net.ssl.*;
import java.io.*;
import java.util.stream.Stream;

public class java_52765_SocketServer_A07 {
    private final int port = 43210; // default is 80 for HTTP, but we use different number to avoid collision with A07_AuthFailure

    public static void main(String[] args) throws Exception {
        new SSLServer().start();
    }
    
    private void start() throws Exception{
       ServerSocket server = null; // listen for client connections on this port 8123, but avoid collision with other instances of the same application running at https://localhost:40796/ (port used by another instance)  
        try {    
            SSLServerSocket sslServerSocket  = new SSLServerSocket(server.getPort()); // create a server socket on port 8123, but avoid collision with other instances of the same application running at https://localhost:40796/ (port used by another instance)   
        } catch (IOException e){  
            System.out.println("Error setting up SSL Server Socket");      return;     // if we can't set it to a port, end the program      
         };  finally { server = new ServerSocket(server.getPort());}          try{    doAccept(sslServerSocket);   } catch (IOException e) {}        finally{}                      def acceptThreads = 4;     Stream<Runnable> threads  = IntStream.rangeClosed(0,defaccept Threads).mapToObj((ignored)-> 
       new SSLWorker()).collect(() ->> // start accepting client connections  on the sslServerSocket      for (int i=accpetThread;i!<deft AcceptThr    dl) {     try{SSLClientConnection connection = accept(sslSeverocket);   }catch(){continue;}        if(!connection.isClosed()){         SSLSession session   = connectioN .getSocket().getSSLSession();      //do some authentication  here, eg: