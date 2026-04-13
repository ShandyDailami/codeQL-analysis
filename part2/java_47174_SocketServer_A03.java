import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;  // For ExecutorService & Future  

public class java_47174_SocketServer_A03 {
    private static final String KEYSTORE_PATH = "/path/to/yourKeystore";    
    private static final String KEYSTORE_PASSWORD =  "password1234567890!";  // or any password you prefer      
  
// SSLContext initialized in a non-thread safe way for instance by using thread local variables (TLS)       
private volatile SSLServerSocket serverSocket = null;   
     private ExecutorService executor=null ;          
         public void init(int port){            
          try{               System.out.println("starting socket server");            this .serverSocket =  new  SSLServerSocket(port,new SSLActivityListener(),KeyStoreUtils.loadKeyStore(KEYSTORE_PATH , KEYSTORE_PASSWORD),null);     }catch (IOException e){System.err.println ("failed to listen on port " + port );throwablesegalstateexception} catch 
   1 {             System .out.print("starting pooled thread model");               this   executor= Executors.newFixedThreadPool(5);     }catch (Exception e){System .err..println ("failed to setup Thread Pool" +e );throwablesegalstateexception}       // end initialization 
public void start(){    try{            System          out      .print("waiting for connection on port: %d   ---[%s]---\n "     , serverSocket.getLocalPort(),serverSocket.toString());while (true){         Socket socket=null;        try {socket = this 
servlet() ;} catch(Exception e ){System .err..println("error occured in accept" +e );continue;}           if   (socket == null) continue     }catch   13-exitCase"){} // handle unsupported operation exception and exit from server: '