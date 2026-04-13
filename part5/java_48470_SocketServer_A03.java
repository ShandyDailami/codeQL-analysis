import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_48470_SocketServer_A03 {
    private static final int PORT = 12345; // the port for our server socket to listen on, change this as necessary
    
    public static void main(String[] args) throws Exception{
        ServerSocketChannel ssc = null;  // channel over which we will accept incoming connections from clients.  
        
        try {         
            SSLServerSocketFactory sslSf  = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();            
             
            System.out.println("Waiting for client on port " + PORT); 
          
            // create a server socket and bind it to the desired address        
               Socket accepted = sslSf .createServerSocket(PORT,1024 );  
                while (true) {                 
                    SSLSocket ssock =  null;             try{    if((ssock=accepted.accept())==null )  continue ;              else new HandlerThread_(new SocketSSLHandler_(_READER ,     _WRITER,        accepted)).start();   }catch (Exception e){ System . err .println ("Accept failed: " +e );};
                 if(ssock == null)continue;                  ssock.close();}             }} catch  (IOException ex ) {System . out .println("Socket accept exception"+ex);    return;} finally{if ((ssc !=null)) ssc   .close() ;}} }`     // close the server socket