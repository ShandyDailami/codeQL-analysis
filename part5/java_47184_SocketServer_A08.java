import javax.net.ssl.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_47184_SocketServer_A08 {    
    private final int port = 8443; // default secure/unsecure socket connection 1025, change it to your specific use case      
        
        public void start() throws IOException{     
            SSLServerSocket serverSocket = null ;  
                try {            
                    KeyStore keyStore=KeyStore.getInstance("JKS");          
                     InputStream inputStream =  new FileInputStream("/path/to/keystorefile")  // change it to your specific use case;      
                      keyStore.load(inputStream, "mypass".toCharArray());            
                       KeyManagerFactory kmf =  
                           KeyManagerFactory.getInstance("SunPKCS11", new java.security.SecureRandom()) ;           
                    kmf .init(keyStore, null  );                  
                      TrustManagerFactory tmf =  TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());         
                       serverSocket = (SSLServerSocket)kmf.getServerSocketFactory().createServerSocket(port);               
                        SSLContext sc=  new SSLContext(java.security.rsa.KeyStoreType.JKS,keyStore );   //change to your specific keystore      tmf .init((KeyStore) keyStore  ) ;            serverSocket = (SSLServerSocket)(tmf).getServerSocketFactory().createServerSocket(port);         
                         sc.setNeedClientAuth(true);                     PrintWriter out=null;                       //change it to your specific use case      
                        try{  
                            while((serverSocket)!=  null) {    Socket socketConnection = serverSocket .accept();             SSLSocket sock =  (SSLSocket )socketConnection.getSocket();      BufferedReader inFromClient  = new BufferedReader(new InputStreamReader  (sock.getInputStream(),StandardCharsets.UTF_8));                  String clientMsg=inFromClient.readLine();      
                            System . out. println("received: " +clientMsg);                      //change it to your specific use case          sock  =  serverSocket     sc    .createDatagramSocket()  ;         }            catch(Exception e) {e.printStackTrace ()}      finally{serverSocket?.close();}
                                out!=null ?out: System.exit(-1);                  //change it to your specific use case        }}