import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class java_53299_SocketServer_A07 {
    private static final String USER_FILE = "src/main/resources/users"; // File containing users (username, password) in CSV format: username,password 
                                                             // Example user file could be created using online tools like https://www.freeformatter.com/csv-table-generator/#home
    private static Map<String, String> USERS = new HashMap<>();  
    
    public java_53299_SocketServer_A07(int port) { 
        SSLServerSocket serverSocket  = null;         // Socket for accepting incoming connections over secure channel.      
      try{                    
          ServerSocket ss=new ServerSocket(port);                   
           System.out.println("Waiting to receive connections on Port : "+ss.getLocalPort());    
                  SSLServerSocket sslserversocket = (SSLServerSocket) ss;   //SSLSocketserver socket 
                   X509Certificate cert= null ;    CertificateEnrollment enrollment  =null;       EnrollmentResult result   =null;      KeyStore keystore =  null     ; TrustManagerFactory tmf    =null;        Socket s =null;   int i= 1;) {                    
                  SSLSocket sockettosenddata=(SSLSocket)sslserversocket.accept();              System.out.println("Connection Accepted");                  
                             //Create a new Thread to handle the request  for each accepted connection             NewThreads T =new       threads      (sockettosend data);                  }}}}                    catch(Exception e){        if((ss)!=null) ss .close();                      System.out.println("Closing down");             
          }}catch   IOException ex1    {System. out  . println (" Server not accepting connections : " +ex );}                   try{             keystore = KeyStore.getInstance(“JKS”);      tmf=new     PKIXTrustManagerFactory().loadKeyStore       (keystore,           password         
              null ,null ) ;    SSLContext sc  =SSLContext .getInstance("SSL");            sslserversocket  =  ((SSLServerSocketImpl)ss).getSSLServerSocket();sc.init(sockettosenddata             checked      Exception                {System..println         ("Failed to accept connections : " +ex);}