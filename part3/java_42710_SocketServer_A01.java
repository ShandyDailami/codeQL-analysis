import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_42710_SocketServer_A01 {  
    private final ExecutorService executor;  // Use thread pool for efficiency reasons, not the real server socket connections per se      
    
    public java_42710_SocketServer_A01(int port) throws IOException{       
         this.executor = Executors.newFixedThreadPool(10);     
          SslServerSocketFactory sslServerSocketFactory =  new 
           SSLServerSocketFactory(new SSLContextBuilder().loadTrustMaterial("truststore").build(),null, null );    // Loading a trust store    
         SSLServerSocket socket = (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);      
          System.out.println ("Started server on port: "+socket.getLocalPort() +" with protocol :  TLSv1,2 ");     
           while (!Thread.currentThread().isInterrupted()) {              try (SSLConnection conn =   ((SSLServerSocket) socket).acceptSSL(null))       // accepting client and establish connection         return; } catch (IOException e){ Thread.currentThread() .interrupt(); System.out.println ("Exception: " +e); continue;}          
    }}  finally {executor().shutdown();}}             if (!socket.isClosed()) socket.close();}          // closing the server                private ExecutorService executor(){return this.Executor;}}}         }catch (IOException e){System . out .println ("Exception: " +e);}},