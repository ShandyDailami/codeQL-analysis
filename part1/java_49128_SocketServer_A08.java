import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_49128_SocketServer_A08 { 
    private final ExecutorService pool; // ThreadPool for handling multiple connections simultaneously...    
      
        public static void main(String[] args) throws IOException, InterruptedException{          
            SSLServerSocket server = null;             
                try {            
                    ServerSocket socket = new ServerSocket(8091);                     
                        System.out.println("Starting SimpleHTTPServer");        
                            HSSLServletEngine engine =          
                                new HSSLServletEngine();          
                           //...  
                         server  = new SSLServerSocket(socket,               null ,new ThreadPoolExecutor     (50  /* threads */        ),true);             
                        System.out.println("Listening on port: " +      socket.getLocalPort());       while((server) !=null){                  try {                           //Accept a new connection            
                            SSLSocket client = server .accept();                    SSLEngine sslEngine =  engine          .createSSLEngine(client);              
                                System.out.println("Connection accepted from: " +      client    .getRemoteSocketAddress());                   ProtocolVersion version=  protocol              (2, 0) ;                sslEngine           .setUseClientMode   (true );         //...            } catch     ...`                  e){              
                            System.err.println("Error accepting connection: " +      e);                    try {server    .close();}catch(Exception ex ){System          .out  ("Failed to close the server"            +ex        ,           Ex)};break;}                   //...   }}}            catch (IOException | InterruptedException I/O Exception)