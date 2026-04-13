import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Logger;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import org.apache.commons.lang3.StringUtils;
public class java_51006_SocketServer_A01 {  
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class .getName()); 
      
        public void start() throws Exception{    
            SSLServerSocket serverSocket=null;        
             try          
                // create a new instance of the secure socket factory  
                    {     
                        SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();   
                         
                         ServerSocket serversocket  =sslserversocketfactory .createServerSocket(8091);  // assign a port to the server socket and bind it  
                      LOGGER.info("Starting Secure Socketer at Port: "+String.valueOf (portsunbound ) );   
                       ((SSLServerSocket) serversocket).setNeedClientAuthentication(true);      
                        while( true){     
                            SSLSocket sockets=sslserversocketfactory .accept( serversocket  ,1024 *5,  3600*1000     // start up a new thread for every client socket and allow the server to accept multiple clients concurrently.    );          if (sockets==null )       continue;     
                             Thread handle =new HandlerThread( sockets);           LOGGER .info("New Connection accepted from: " +   ((InetAddress)  sockets     .getRemoteSocketaddr()).toString()+"");        // accept new connection, create a thread for that client    );         }          catch (IOException e ) {              if(!serverSocket.isClosed()) serverSocket     
                        =null;       LOGGER             .info("Secure Socket Server Stopped at Port: " + StringUtils 
                        .replace(String   .valueOf((long) portsunbound)," ", "%20"));                  e     = null ; }          if (serverSocket    !=  nu ll ) serverSocket.close();}catch      ...{         LOGGER               ` INFO("Error in starting the Secure Socket Server: " +  
                        sockets);       throw;}}  catch(Exception ex) {LOGGER .warning ("Server fail due to :"+ex );throw new Exception (    "_Global_exception");}     }      // main function ends here ......end of code.        public static void mian[...](string[] args){try{new SecureSocket server().start();  
                        }}  /*End Of Code */}};