import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;   //For ExecutorService and Callable task handling   
    
public class java_51719_SocketServer_A01 {     
       private static final int port = 8095;            
       
  public static void main(String[] args) throws Exception{             
          SSLContext sslcontext = getSSLContext();                    
           ExecutorService service  = Executors.newFixedThreadPool(1);     //thread pool to handle request tasks     
           
         try {                 
                ServerSocket socket= (ServerSocket)(sslcontext).accept();  
            
                    System.out.println("New Connection Accepted: "+socket );      
                     service.execute(new ClientHandler(socket));     //handling client requests in separate thread   
            }  catch (IOException e){       
                  sslcontext.getProvider().destroy();              
                   throw new Exception(e);                       
             };               
         });     
   }      
         
private static SSLContext getSSLContext() throws Exception{     // create an instance of the KeyStoreExplorer class 
           try {                          
                  String keyStorePath = "path_to/yourkeystore";   
                   char[] passwords []= {'p','a','s', 'w'};             
                 SSLServerSocket socket   = (SSLServerSocket)new SSLServerSocket(port);          //create Server Socket  
               KeyStore keystore = KeyStore.getInstance("JKS");     
                InputStream inputstream  = new FileInputStream("/path_to/yourKeystorePasswordFile "); 
                 keystore .load(inputstream, passwords[0] );   
                    SSLServerSocket sslserversocket= (SSLServerSocket)socket;        //make it secure  
                  KeyManagerFactory keyfactory =      new KeyManagementSystem().getKeyManagers();     //create a factory for the keystore  and initialize with our privatekey.      
               TrustManagerFactory trustmanagerfactor  =newX509TrustManager(".truststore");// create x509信任管理器和工厂  
              keyfactory .init(null, new KeyStore[]{keystore}, null);                     //set the factory for init with our keystores  and passwords.      
             trustmanagerfactor    .init(new java.security.cert.X509Certificate[] {      getClientCert() },   null );     /* set x509 Certificates */            TrustManager []trustmanagers={                  new X509TrustManager(){...}},       
             SSLContext sslcontext1 =SSLContext .getInstance("SSL");       //initialize the Context with our trusted managers and algorithm.      }catch(Exception e){         System.out.println ("Error in establishing "+sslc );            return null;    };           catch (java.lang.Exception