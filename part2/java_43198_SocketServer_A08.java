import java.io.*;  // Import required classes  
import javax.net.ssl.*;    // For ssl socket factory and key store stuff only (no security)
import java.util.*;     // for ListenerSet, Collections methods
...
// the main method to set up a server that uses SSL/TLS with checksum protection: 
public class java_43198_SocketServer_A08 {  
    public static void main(String args[]){     
        try{        
            ServerSocketFactory ssrf = (ServerSocketFactory)SSLServerSocketFactory.getDefault();           // for ssl socket factory and key store stuff only using standard java libraries         
             SSLServerSocket serverSocket=null; 
              ListenerSet ls = new ArrayList<Runnable>( );   /* A set to hold our listener (runnables) */     
         ...     }    catch (Exception ex){                  // Catch any exceptions which are thrown by the Server and its Socket methods or classes.        Logger log=LoggerFactory .getlogger("server") ;  log_.info(ex);}   return;                 }}           finally {                   if(!isnull((Socket)socket)) try{ socket_down(); } catch (Exception ex){ loggerlog..errorex;" server down" );}}     
        ... // Rest of your code here, this is where you do the actual work.  You accept connections and start threads for each connection...   }}           private static boolean isnull(Object obj) { return((obj == null )|| (obj instanceof javax_net_ssl_.SSLSocket)); }         
         ... // Here goes your code to handle sockets, checksums etc.. you would then run the listener on these threads.  For simplicity's sake we just call new Thread(runnable) for each connection...       }}             catch (Exception ex){ logerror("accept failed",ex);}           
         ... // Rest of your code here }}}    class MySSLServerThread extends Runnable{   private Socket socket; public  void run(){ try {socket=serversock.accept(); Thread t = new T(this, "thread-"+count++ ); serverserver_downlistener (t); }}     // Here I use your existing code for handling sockets
        ... } catch (Exception ex){ logerror ("run failed",ex)}}}  class LoggingRunnable implements Runnable{ public void run(){ try {...}}   private static final String LOGGING_PATTERN = "%d{yyyy-MM-dd HH:mm:ss} %p %c{1}:%L - %m%n";     // The logger uses the above pattern for log messages.     
        ...  }} } catch (Exception ex){ LoggerFactory .getlogger("server").error ("main failed",ex);}}   System.out..println(e)}}}             `