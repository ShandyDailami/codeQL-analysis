import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.channels.*;
public class java_49454_SocketServer_A01 {  
    private static final int PORT = 7001;     // Port number on which server is listening 
        ExecutorService executor = null ;       // thread pool for handling multiple clients requests concurrencyly     
        
          public void initialize(){             // Initializing socket and its handler           
              try {                           
                 SSLServerSocket sock= (SSLServerSocket) new SSLServerSocket(PORT); 
                     System.out.println("Secure Server Started at port: "+ PORT );   
                       executor = Executors .newCachedThreadPool();       // Creating thread pool          
                      while(true){               
                          SocketChannel sc=sock.acceptSocket() ;           
                           if (sc != null) {                              
                                System.out.println("New Connection Accepted: " + sc );    
                                     executor .execute(new SecureClientHandler(sc));  // Executing task to handle the client socket   }}}                   catch (IOException ex){System.err.println ("Exception caught on server side"+ex);}                 }}            finally {sock.close();}}}                          };    class Handshake implements Runnable{          
          public void run(){                     // Implementing hand-sha king mechanism via SSL/TLS for secure client & Server communication       try   (SSLServerSocketChannel ssc =(  SSLServerSocketChannel) sock;                   SSLContext sc=SslContextBuilder.create().build();                  KeyStore ks=  KeyStoreBuilder .newKeyStore("src//main//resources", "mypassword".toCharArray(),"myPassword");            
              if (true){                           //Handshake to establish encryption & decryption keys          try { sc = ssc.acceptChatSession();                                                    SSLSocket socket=(SSLSocket)  sc .getSockethandler() ;                  BufferedReader br=  newBufferereadrInputStream   ((int )socket-> getInetport ());    
              // Reading client's data and respond back using ssloutputstream         System.out,println ("Handshake Message: "+br . readline());             socket..printwriter(bw ,"Hello Client");           } catch   {System .. errr("Exception in hand shake" +ex);}}                  finally{socket。close();scsocethandlereventlistener.accept())}catch (SSLHandshakeExc e){ System out .println (" SSL HandShaking Failed: "+e)}}}