import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class java_46324_SocketServer_A03 {
    private static final int PORT = 8091;
     // Path to your keystore, truststore and passwords should be replaced with real ones  
      String KEYSTORE_PATH = "/path/to/your.keystore"; 
      String TRUSTSTORE_PASSWORD="trustStorePassword";   
       char[] PASSWORDS  = {'t','r','u','s','t'};     //password for keystore and truststore  
        KeyStore keyStore = null;         
         TrustManagerFactory tmf ; 
             SSLServerSocket serverSocket=null,sslss=null;   
              ExecutorService executor= 
                 Executors.newFixedThreadPool(10);     //thread pool size set to avoid possible DOS attack  
           public java_46324_SocketServer_A03() throws IOException{     
               InputStream inputstream = null ;        SSLSocket ssl=null;       KeyManagementExtention kmfex =  new  KeyManagementExtention();    TrustManagerFactory tmf= 
                  (TrustManagerFactory)kmfex.getObject("TS");          // Initialise trust manager factory  
               keyStore  = KsUtils .loadKeyStore(KEYSTORE_PATH,PASSWORDS);     
                sslss= new  SSLServerSocket((SSLServerSocket)serverSocket ,tmf,(SSLContext )keyStore.getDefaultAlgorithm());          // Initialise the Server Socket with given trustmanager factory and keysore   }     @Override    public void run(){         try{        while(true){            if(!isInterrupted() && (ssl=((SSLSocket) sslss .accept()).getSocket())) {               executor.execute(new ClientHandler(ssl));           }}catch 
      catch(Exception ex ){}finally {} }     private class KeyManagementExtention implements KeyManager{ @Override public SSLContext getContext(String host, String[] localCertificates,       char[] challengePassword){          return null;}}    static {try   {KeyStore ks=KsUtils.loadKeyStore("keystorePath",PASSWORDS);  tmf  = new    
      TrustManagerFactory (ks,"truststorepassword".toCharArray());}catch(Exception ex) {} }             public class Ksutils{       static KeyStore loadkeySTORE   ("pathToYourKeystore","yourPassword").thenAccept... .accept("Trust store password") };   
              private  final int PORT = 8091;      //set port number.     Socket socket=null ;         try {socket = new       Socket(InetAddress.getByName ("localhost"),PORT); } catch (UnknownHostException e) {}catch   ...}        finally{}
             @Override public void run(){  if(!isInterrupted() && !((Socket)sock).isClosed())     try{while ((clientMsg = br .readline())!=null ) { out.println( clientmsg );}} catch (Exception e){e.printStackTrace(); }}
               // close the socket, reader and writer  if they are not already closed   }    private static void onClose() throws IOException      {{ try{sock.close(); br .close();out .close();}catch       ...}}}     public class Main {public synchronizedstaticvoid main(String[]args){SecureSocketsExample s=new SecureSocketsexample;try         
               {    Thread th = newThread (e);th.start()}} catch  ...... }`!@#$%^&*();:?>|./,.;+"_-+|}{[]{}' "