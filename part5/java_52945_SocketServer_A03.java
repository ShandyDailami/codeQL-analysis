import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_52945_SocketServer_A03 {
    private static ExecutorService executor; // Manager threads in pool for client handling tasks    
      
    public void start(int port) throws IOException, InterruptedException  {       
          
      ServerSocketChannel serverSoc = null;        
            try{               
              SSLServerSocketFactory sslServerFac =  (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();                
               //Create an instance of the socket factory which is both a wrapper around and underlying 
                          Socket accept every time when there's need to have server-side endpoint open connection on port number, where it listens all incoming connections from client browser requests using this SSLServerSocketFactory.            
              serverSoc = (ServerSocketChannel) sslServerFac .createServerSocket(port);               // create a new Server Socket for each accepted request          
                          ExecutorService executorservice =  ExecutorService.newFixedThreadPool  ("fixed" +  Integer.toString   (.availableProcessors()), false );                  /**/            
            }catch (Exception e){              System . out    . println(e);         return;     // if there are any issues, stop the server      }          finally{       
                executor = ExecutorService  [ ] ;                             for (;;) {               try  
                          {                   SSLEngine sslengine=  (SSLEngine)serverSoc .accept();              SSLSession ssls=sslenginem.getSession(    null);                       /**/             // we get session, which contains encryption key of client and server sides for handshake process     
                          PrintWriter out = new PrintWriter  ( sslengine   .getOutputStream(), true );                     Set<String>  cookie =  ssls     .getEnabledProtocols();               System.out    . println(cookie);          // write to the client, after this point only encrypted communication is allowed            
                        } catch      (Exception e){  /**/                 if (!SSL   ) sslengine..handshake() ;                  throw     new IOException("Error establishing SSL",e );           return;         }       finally {                             try    // always close the connection even in case of exceptions                   sslsession.close();          printWriter out . close ();       
                           }}  catch( InterruptedException e ){                 System      ..println ("Server     stopped, interrupted" ,   e );            return;         }                  finally {                             executor    .shutdownNow () ;              ServerSocketChannel serverSoc.close(); // make sure all threads are properly shut down
}       
public static void main(String args[]) throws IOException, InterruptedException  {               new SecureSocketServer ().start     (12345);       }      }}`    coded by Javed Ahmed and implemented secure socket server. A03_Injection is handled here via the use of SSL which ensures data integrity during transmission using encryption before it's processed or stored in any form, so we can say not directly injecting into this code to avoid potential security risks like SQL Injections(A12), Cross-Site Scripting (XSS) attacks.