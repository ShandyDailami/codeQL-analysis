import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;

public class java_52965_SocketServer_A03 {    
    private static final int PORT = 8443; // HTTPS port 9025 is standard, also used by Tomcat and Jetty
     
    public static void main(String[] args) throws Exception{            
            ExecutorService executor = null;              
                try {                 
                    KeyStore keyStore =  KeyStore.getInstance("JKS");                    
                        InputStream inputStream= new FileInputStream("/path/to/yourkeystorefile") ;    //Keystores file 
                      keyStore .load(inputStream, "password".toCharArray());                  
                       TrustManagerFactory tmf =   TrustManagerFactory.getInstance("SunX509");                    
                          KeyStore trustStore =  KeyStore.getInstance("JKS");                   
                           InputStream truststoreInputStream= new FileInputStream("/path/trust_file") ;  //Trust store file         
                             trustStore .load(truststoreInputStream, "password".toCharArray());           tmf.init(keyStore);                        TrustManager[] managers =  tmf.getTrustManagers();   if (managers.length != 1 || !(managers[0] instanceof  X509TrustManager)) throw new RuntimeException("Unexpected default trust managers");    
                          SSLServerSocket server = null;      ServerSocket socket  =null ;            int recv = 0, sent = 0 , ssl_handshake= 0    ,ssl  = 0 ;             executor    = Executors.newCachedThreadPool();                while(true) {SockedRemoteConnection conn=server .accept()  Thread t = new ConnectionHandler (conn);executor..submit(t ); }
                            finally{               if ((socket != null)) socket.close();     System.exit(0)}   private class ConnectionHandler extends FutureTask<String> {}             void closeDownStreamConnection(){ /*closes down a connection */}    public SSLServerSocket createSSLserverSocker() throws Exception {       return new  SSLSocketFactory().createSocketServerSocket (PORT,null ,5);}}