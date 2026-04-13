import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_43884_SocketServer_A07 {
    private static ExecutorService executor;
    
    public static void main(String[] args) throws Exception{
        SSLServerSocket server = null;  //SSL Server Socket to accept client requests, secure connections only possible with certificates.  
        
            try (SSLServletContext sc =  sslcontext().createServletContext("default")) {   
                System.out.println(sc);                                                 
                                                                                   
                   server = new SSLServerSocket(4023 , null,null  );              //creating a listen port for secure communication on the specified number     and bind to that socket with all certificates in truststore  
                     executor  = Executors .newCachedThreadPool();                         
                                                                               
                    while (true) {                                                 
                        SSLSocket client = server.accept() ;                           //blocking call, wait till a request comes  on the listen port    and accept this connection                  
                         System.out.println("Client connected");                                  
                                  executor .submit(new SocketTask(client));    
                    }                                                                     
            } finally {   if (server != null) server.close();}                        //closing of SSLServerSocket is essential in case exception occurs  to free resources    and close socket connection with the client                 
        }}`;