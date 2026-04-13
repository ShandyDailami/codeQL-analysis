import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_52210_SocketServer_A08 {
    private static final String KEYSTORE = "path to your keystore"; // path to .keystore file, password and alias must be set up properly in the command line when running this code 
                                                            // (e.g., keytool -storepasswd -keystore myKeystorePasswordStorePassHere)
    private static final String ALIAS = "your_alias";   // use same one as above and used while creating keystore in command line when running this code 
                                                            // (e.g., keytool -list -keystore myKeysToListAliasPasswordStorePassHere)
    private static final String SSLServerPort = "12345";   // port to start server on, default can be any available one for your purpose in this example 
                                                            // (e.g., netstat -ano | findstr :<SSLserverport> ) or you may use an arbitrary value such as '9086' if not set yet     
    
    public static void main(String[] args) throws Exception {        
        SSLServerCertificateExtractor sslHandler = new SSLServerCertificateExtractor();       // create instance of the custom handler  for accepting client certificates.  	                                                                                            		          			                                  }                                                    ,SSLContext context;    								    private static ServerSocket socket ;     									 public class SSLAdminTask implements Runnable {         @Override       	public void run()         	{             try      
{ Socket s =socket=new SSLServerSocket(Integer.parseInt (SSLServerPort), null,null ,true);	 //create and start the server with TLS on specified port 12345  			      if (!sslHandler .isClientCertificateRequired())         	socket  = new ServerSocket();             }catch    
                                                                   ​(IOException e) {e.printStackTrace()}           sslServer= (SSLServerSocket )socket ;       socket = null;         SSLCertificate cert,chain;int i = 0;           	try{for   (;i<1548 ;  //set a limit on maximum no of connections for demonstration purposes             while(!Thread.currentThread().isInterrupted()           &&(cert=sslHandler .getClientCertificateChain())!=  null){               chain = cert                     IOUtils   
                                                                                 ​..println("Received certificate :"+chain);   }          sslServer  //close the socket      if (socket !=null)         try     {s.close();}catch(IOException e1 ){e1 .printStackTrace() ;}}           finally           	{             Logger   
                                                                                 ​..println("Closing Server: " + SSL_SERVERPORT);        }} catch  IOExcepti   on (SocketException       s)      {s.printStra     inck();}catch(SSLHandshakeException e){e .prin         tStackTrace() ; }          
    //add more code to handle client requests if any based upon the use case, we can also add exception handling for all 4 types of exceptions here like IllegalArgument...exceptions. I will leave this part out in detail as it depends on your specific needs      									  	}}}             Logger .log("Ended");}}