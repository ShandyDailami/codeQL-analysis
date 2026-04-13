import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;
  
public class java_53001_SocketServer_A08 { 
    private static final Logger LOGGER = Logger.getLogger(SSLClient.class.getName());
      
      public void start() throws IOException, GeneralSecurityException{    
        KeyStore keyStore=KeyStore.getInstance("JKS");            //create JKs keystore  
           Socket socket;        
          SSLServerSocket sslServerSocket = null ;                
             try {                  
              System.out.println ("SSL Server Started ... ");     
               keyStore.load(new FileInputStream("/path/to/.keystore"),"password".toCharArray());    //Load your keystone and password  
  SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();    
              socket=sslServerSocketFactory .createSocket(8012);//port number must be higher than used by other application       //Create a new server-side SSLeSocket  
          sslServerSocket  =new  SSLServerSocket (socket,keyStore,(SSLServerSocketFactory)null );         ///Bind the socket to port and keystore.   
                 while(true){                                                       if((socket=sslServerSocket .accept()) !=  null ){                   //Accept a new connection             
               System.out.println("New Connection Accepted"); 
                     SSLSocket sslSock = (SSLSocket) socket;                      SSLLoginContext logc = 	new  				   			//SSL Handshake using 'Login' context which is set in above line       //hand shake to the client                          sslsocK.startHandshake(logc);                                                        
            try {                                                MessageDigest md =MessageDigest .getInstance ("SHA-256");     BASE64Encoder encoder= new	BASE64Encoder();  String encPass=  (encoder   	.encode("password".getBytes()));      //Password is encrypted before handshake.  
            byte[] certRaw = sslSock .getCertificate().getBytes( );     md .update(certRaw);       System.out.println ("Client Cert: " + new String (md 					.digest("SHA-256"))));      //Digits are encrypted before handshake            
            } catch (Exception e) {                          LOGGER   		  	Logger     .getAnonymousLogger().log(Level.SEVERE,"Error while processing certificate",e);                                                  continue;  }}catch{                 $LOGGER        Logger             	.getAnonymousLogger()     	   				      
            logger               					         	 	     			                       LOGGER   		  	             log     .error ("Exception caught in try- catch block ", e );               }}}}}}                                                                           if(sslSock != null){ sslSock.close();} socket =null;                 }}catch (GeneralSecurityException gsse) { $LOGGER        Logger             	.getAnonymousLogger()     	   				      
            logger               					         	 	     			                       LOGGER   		  	             log     .error ("Error while processing SSL",gsse);               } catch(IOException ioe){                   $LOGGER         Logger. getAnonymouslogger().log (Level,SEVERE,"Exception caught in I/O Block ",ioe );                continue;}}}}}