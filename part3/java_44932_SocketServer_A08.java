import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_44932_SocketServer_A08 {  //class name should match the file which it generates, this is a convention (Java naming rule).
    private static final String CLIENT_CERTIFICATE = "src/clientCertificate.pem";   /* path to your client certificate */    
    private static SSLContext sslcontext;  //global object for managing our context and objects in it            
                                                       
                                  public void startServer(int port) {                 
                                     Runnable certValidation = () ->{                                     
                                         try (SSLServerSocket serverSocket =  new SSLServerSocket(port, null))    /* we are handling a single socket here */             
                                             , Certificate clientCert  = sslcontext.getCertificate(serverSocket)}  // getting the certificate from our context    
                                        {                                                                  
                                            System.out.println("Waiting for connection on port " + serverSocket);     
                                                try (SSLConnection conn = ( SSLConnection ) serverSocket . accept())    /* accepting a client socket */             
                                                    , InputStream inStream  = conn.getInputStream()                      // getting the input stream from our connections    
                                            {                                                                  
                                             BufferedReader reader =  new BufferedReader(new InputStreamReader(inStream));       // buffer for reading data                                 
                                                String string ;  /* we'll use this to hold incoming messages */                         
                                                 while (((string = reader.readLine()) != null)) {                    /* loop until the server closes down connection with client*/                           
                                                     System . out .println ("Received: " + string);                      // display what we received    
                                                }                                                                  /* closing our input stream */                             try{conn.close();}catch(Exception e){}}    catch (IOException ioe) {try{ conn.close() ;System.out.println("Connection closed");return;}catch(Exception ex){ }}   System . out . println ("Closed connection " + serverSocket); return; }
                                             finally  //finally block ensures that the connections get properly closes down no matter what happens in try-except blocks                                                  catch (IOException ioe) {try{conn.close();}catch(Exception ex){ System.out . println ("Closing connection " + serverSocket);}}     }
                                         finally  //finally block for sslcontext to avoid memory leaks   if any exception occurs in try-except blocks it gets caught and closed    catch (SSLException se) {sslcontext.getCertificates().clear();try{if(null != sslcontext){sf = new FileInputStream("src/serverKeyStoreFile"); pkcs12.getPrivateKeyAndCertificateChain("/path_to_yourPKCS#12", "password".toCharArray());} else {se.printStackTrace();}} finally{if(null != sslcontext){sslcontext = null;}}}
    public static void main (String args[]) throws Exception  // the following lines of code are for setting up our SSLContext object, where we load in client certificate and setup a keystore   {     if (( new File("src/clientCertificate.pem")).exists() ){ sslcontext = SSLContextBuilder    .create().loadKeyMaterial( CLIENT_CERTIFICATE , "password".toCharArray()).build();}}