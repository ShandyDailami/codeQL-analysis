import javax.net.ssl.*;
import java.io.*;
import java.util.logging.*;
import java.net.*;

public class java_51509_SocketServer_A01 {
    private static Logger logger = Logger.getLogger(SecureServer.class.getName());
    
    public void start() throws IOException, SSLException{        
        ServerSocket serverSocket=null;  
       try{            
           KeyStore keyStore  = KeyStore.getInstance("JKS");              
           //Load the client keystore which contains our private and certificate(public keys)                   
           keyStore.load(new FileInputStream("/path/to/yourKeystore"),"mypassword".toCharArray());             
           
           SSLServerSocket serverSSLSocket = null; 
        //SSL Server socket            
         serverSocket= new ServerSocket(1234, keyStore.getClass().getDeclaredField("ks").getType(), true);   
         
               TrustManagerFactory trustManagerFactory= 
                   TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());  //To get default algorithm for the factory    
         KeyManagerFactory keyManagerFactory = null;  
        try{                
            Class cryptoLibraryClass =  Class.forName("javax.crypto");                   
             keyManagerFactory=KeyManagerFactory .getInstance(KeyManagerFactory.getDefaultAlgorithm());           // get default algorithm for factory    
              KeyStore clientkeystore = null;  
               try{                  
                clientkeystore  = KeyStore.getInstance("JKS" ); 
                  String keypassword= "mypass".toCharArray();   
         File file =  new File("/path/yourKeyFile"); // add your keyfile location     
                    InputStream inputstream =new FileInputStream(file);  
                   clientkeystore.load (inputstream,keypassword ); 
                      TrustManagerFactory trustAllContent  =null;               
                       try{       
                            String tmfAlgorithm="SunX509";             //set the algorithm to support SUN_X509    
                         KeyStore truststore = null ;         
                             File trustFile =  new  File("/path/yourTrustfile");   // add your Trust file location               
                          InputStream inputstreamtrust=new FileInputStream(trustFile);             
                        trustAllContent=  (KeyStoreManager)null;           return true;                      if(!SSL.isSupported("SunJSSE"))          {logger .warning ("Java does not support the Sun JSSE API.") ;return false;}               KeyManager[] keyManagers = null, trustManagers={};
                     try  // to get default algorithms for factory      TrustManagerFactory  =  (KeyStore.AlgorithmConstraints)null; return true    if(!(key instanceof SSLSocket)) {logger .warning("This program is not intended for non-SSL Socket connections.") ;return false;}               serverSSLSocket = new 
                     SSLEngineServerSocket((ServerSocket)(server=new ServerSocket()),false,true,(HostResolver)null);    sslsocket.bind(sockaddr_in addr), setNeedClientAuth (boolean needsclientauth),(int)needsca ),             ((SSLContextImpl[]])setUseClientMode 
                     false)},//if(! SSLUtilities .isSupported("Java Cryptography Architecture")) {logger   _warning ("The Java CA is not supported.") ;return False;},sslsocket.accept(), (), ssl, setEnabledProtocols(new Protocol[] {"SSLv2","SSL v3", "TLS"}), null} 
                     else if(! SSLUtilities .isSupported("SunJSSE")) {logger   _warning ("The Sun JSSE API is not supported.") ;return false;}               KeyManagerFactory keyMgrFact= (KeyStore.AlgorithmConstraints)null; return true    //to get default algorithms for factory 
                     try{sslsocket = new SSLServerSocket(server,keyManagers,(SSLContextImpl[]){((HostResolver)"",new String[]{"-Djavax.net.ssl.SNIServerSocketFactory="+SSLServlet.DEFAULT_HOSTNAME}},4096),false); 
                     sslsocket .bind (sockaddr _in addr) },true, ((SSLContextImpl[]){((HostResolver)"",new String[]{"-Djavax." + SSLSocketClient.DEFAULT_HOSTNAME+"="}))   return true;}               if(truststore == null && !isServer()) {logger .warning ("TrustStore not found") ;return false;}, trustManagers = new TrustManager[] 
                     (new X509TrustManagerImpl()), setNeedClientAuth ((boolean)(((KeyManagerFactory)null).getDefaultAlgorithm()=="PKCS12"))),true,sslsocket.accept(),sockaddr_in addr)},false); sslSocket .bind(8463)), //set the port for socket connection on server side
                     false));return true;}}catch (IOException e){logger   _warning ("Failed to start listening at " + address) ;throw new IOException("Listen failed");} catch …. { }    finally{if(!isServer()) unregister();sockaddr_in addr =serverSocket .getInetAddress(). getPort()};}}