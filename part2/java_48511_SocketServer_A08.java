import javax.net.ssl.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;

public class java_48511_SocketServer_A08 {
    private static final SSLServerSocket SERVER_SOCKET = new SSLServerSocket(843, null); // server socket port and provider (null for default) 
    
    public void start() throws IOException, CertificateException{  
        while(!Thread.currentThread().isInterrupted()) {           
             try (SSLConnection sslconnection =  ((SSLServerSocket) SERVER_SOCKET).accept();             
                  SSLSession session = sslconnection .getSession();      // getting the client's socket connection details 
                 ){              
                    System.out.println("New Connection Established");     //inform user          
                   SSLEngine engine=session.createSSLEngine(sslconnection);  
                  /* Create a new session, if required */   
                          sslconnection .setNeedClientAuth(true );  }catch (SSLException e) {      System.out.println("Error while establishing SSL connection: " +e ) ;}     finally{        //close the socket and delete resources used by this Session   ((Closeable)session).close();    }}         
              catch(IOException ex){System.err.print ("I/O Error occurred :"+ex);break;}}         }                };             public static void main (String[]args )throws Exception{ new MySSLServer().start() ;};  });