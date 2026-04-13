import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;

public class java_52496_SocketServer_A07 {  
    private static ExecutorService executor;  // Pool of threads for handling multiple connections concurrently    
      
        public void start(int port) throws IOException, InterruptedException{        
            ServerSocket server = new ServerSocket(port);     
             System.out.println("Server is listening at Port: " + port );   
              
                while (true){                  // waiting for client to connect         
                    final Socket socket=server.accept();          
                          executor.execute(() -> {                       // thread per connection        
                            try{                
                                  SSLSocket sslServer = null;             
                                      if(socket !=null)  
                                          sslServer=  (SSLSocket)  socket .createChannel(socket.getInputStream(),false);       
                                           else return ;      
                                      
                                   PrintWriter out =  new  PrintWriter((new BufferedWriter(                   // wrapping the Socket's input stream in a BufferedWriter for thread safety     
                                        new OutputStreamWriter (sslServer . getOutputStream()))));  
                                  SSLCertificate cert = sslServer.getSession().getPeerCertificate();    BouncyCastle钥匙交换  // getting the peer certificate       
                               if(cert == null) { out.println("Unable to authenticate client"); return;}     else System .out      .print ("Client Cert : " + cert);   }       catch (Exception e){                   try{ sslServer . close(); socket?.close() ;}catch    (IOException  ie){}}            
                              finally { out.flush(); out.close();}}} );          executor.shutdown();           System ..     println ("Shutting down the server");   } catch(Exception e) {}         while ((socket =server .accept()) != null ) socket.close() ;            if (executor instanceof ExecutorService){ 
                           try { executor..shutdown();}catch    (SecurityException se){}} finally{ // cleanup: stop the executorservice      server   .. close(). wait(10); } catch     (InterruptedException e) {}         System . out. println ("Server Stopped");        return;}}}