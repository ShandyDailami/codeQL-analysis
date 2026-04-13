import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_51349_SocketServer_A01 {
    private final int port = 12345; // default HTTPS server port, change as needed 
    
    public static void main(String[] args) throws Exception {  
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());        
       new SSLServer();     
    }         
              
    private SSLEngine createSSLEngine() throws IOException, SSLException  {    
            SocketAddress address = new InetSocketAddress("127.0.0.1", port);       
                    
           KeyStore keyStore =  KeyStore.getInstance(KeyStore.getDefaultType());            
          //You may need to change this filename and password for your environment, these are example values             
            String keystorePassword = "password";      
            char[] keystorePassCharArray  = keystorePassword.toCharArray();  
                   KeyStoreInputStream ks = new KeyStoreInputStream(getClass().getResourceAsStream("myKeystore"),keystorePassCharArray);              // replace myKeystore with your key store file path and password                    
           trustManagerFactory =  TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()); 
             if (trustManager == null) {    
                  String tmfAlgorithm = "SunX509";       stringResourceBundle  =  ResourceBundle.getBundle("Client");    //replace Client with your key store provider alias or name      }          trustAllCerts =  true;        KeyManagers  = new KeyManager []{ km };         return  engine ;    
}              catch (Exception e) {            throw new IOException(e);   }) );       executor.execute(() -> serve()); // start the server in a separate thread });    }               private void handleClientConnection() throws SocketException, SSLHandshakeException{ try         SSLEngine engine = createSSLEngine();               
socket  = (SSLServerSocket)server; socket .accept();       BufferedReader  reader  =  newBufferedreader(new InputStreamReader((ssl.getInputStream()));        String msg ; while ((msg=readLine())!=null){ // read message from client ... } close it up here if needed     finally {    ssl.close(); }} catch (IOException e) {}
}  private void serve() throws SocketException, SSLHandshakeException{   try       SSLEngine engine = createSSLEngine();        socket  = server .accept( );         BufferedReader reader =  newBufferedreader((new InputStreamReader ((ssl.getInputStream()))));          String msg; while (   
!=null){ // read message from client ... } close it up here if needed   finally {     ssl_close ;}} catch  IOException e {}      private void handleClientConnection() throws SocketException, SSLHandshakeException{ try       SSLEngine engine = createSSLEngine();        socket  = server .accept( );         BufferedReader reader =  newBufferedreader((new InputStreamReader ((ssl.getInputStream()))));          String msg; while (   
!=null){ // read message from client ... } close it up here if needed   finally {     ssl_close ;}} catch  IOException e {}
}