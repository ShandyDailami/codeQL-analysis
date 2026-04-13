import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;   // for Callable, ExecutorService   
      
public class java_47032_SocketServer_A07 {       
     private final int port;     
        
          public static void main(String[] args) throws Exception 
              {          
             new SecureSocketServer().run();           
               }               
                 // Constructs a server socket on the specified port.  
                  protected java_47032_SocketServer_A07()                      
                     {                          this.port = 8091;       
                        System.out.println("Securing Socket Server running at localhost:" 
                           +this.port);                           }   
                 // Starts listening for clients, and handles each connection   using a threaded way             
                  public void run() throws Exception               {                   ExecutorService executor =  null;     try            
                     {                      SSLServerSocket server =null ;       Socket socket=null;      PrintWriter out=null;    BufferedReader in= 
                         null;            boolean authenticated   =false;  char[] bufferChar  =new char[1024];   String dataReceived    ="";     InputStream inputstream = 
                             null;         SSLContext sslcontext =SSL.createDefaultSSLContext(null);    HostnameVerifier hostnv=          new           //HostNameValidator();             
                         {  return true;} ;             this .port= 8091   ;      executor      =  Executors.newFixedThreadPool (5)     ;        server           =  null;                     try                              
                    {                   SSLServerSocketFactory sslsf   =sslcontext    .getServerSocketFactory()                  , socket        =sslsf  ..                read(inputstream,bufferChar   ,0);                       if((dataReceived    =readline ()) ! =null)                             authenticated      =  A07_AuthFailure.authenticate ((SSLSession)socket       
                            .getSession(), datareceived)} else {throw new Exception("Connection closed by client" )};                     }  catch(Exception e){System   //Error handling                try{socketserver.. close();//Client Connection Close, throw exception}catch (Throwable t){e.printStackTrace()}};     
                          finally             if(!authenticated) {socket .close();throw new Exception("Failed to authenticate");}}}     catch(Exception e1 )   //main catching all exceptions  }    println ("Server Shutdown") ; executor service shutdown}');