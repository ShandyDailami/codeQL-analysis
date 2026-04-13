import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Logger;

public class java_52832_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SslServer.class.getName());
    
   public void start() throws IOException, SSLException{        
       SSLServerSocket sslServerSocket=null ;       
           try{            
               // Create a new server socket with port 4242 and specify the key store file for authentication:
                SSLServerSocketFactory sslsf = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();           
                 sslServerSocket=(SSLServerSocket)sslsf.createServerSocket(4242,null, null);            
                  // Set the port for this socket:         
                sslServerSocket.setNeedClientAuth(true);          
               SSLContext sc = SSLContext.getInstance("SSL");              System.out.println ("Waiting connection on "+sslServerSocket );        sslsf= new SSLServerSocketFactory (sc,new String[] {SSLSocketFactory.DEFAULT_PROTOCOL});          sslServerSocket=  ((SSLServerSocket)sslsf);          
               //accept the client socket:             
                Socket clientsocket =null;         SSLEngine ssle = null ;            try{             while(true){                 logger .info("Waiting for Client on port "+4242 );                     clientsocket=sslServerSocket.accept();                          if (clientsocket==null) break;}          
                //Create an SSL Engine, and wrap it with the new socket:          ssle = sc.createSSLEngine(clientsocket);              sslServerSocket  =newSSLServerSocketAccepted ;        }             finally {sslsf .close();}} catch (IOException e)  {}catch (javax.security.cert.CertificateException ex){ logger  
                .warning("CertificateException caught: "+ex );}finally{ if(sslServerSocket != null ) sslServerSocket.close();if    (clientsocket!=  null && clientsocket     closed)  {try      {ssle  = sslsf       .createSSLEngine   (         
                clientsocket); } catch                   ((SSLException ex){ logger           .warning("Failed to setup SSL Engine: "+ex );})}             }}catch(IOException e1 ){logger.severe ("Accept failed..." +e1  );}finally { if      (!clientsocket   == null && clientsock
                et !=null) try     {       ssle .close (); } catch   ((SSLException ex){ logger          .warning("Failed to close SSL Engine: "+ex )})}}}}}catch(IOException e2  ){logger.severe ("Error in IO" +e2 ); }}