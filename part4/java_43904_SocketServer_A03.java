import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.StandardCharsets;
 
public class java_43904_SocketServer_A03 {  
    private static ExecutorService executor = Executors.newFixedThreadPool(10); // thread pool for handling multiple clients concurrently, you may adjust it as per requirement and server capacity    
     
        public static void main (String[] args) throws Exception 
       {           
           SSLServerSocket sslServerSocket=null;            
                try{                 
                    KeyStore keyStore = KeyStore.getInstance("JKS");    // you may use any keystore type like JCEKS, PKCS12 etc              
                    
                   /* Create a self signed certificate */ 
                      SSLServerSocket socketSecure=(SSLServerSocket)sslServerSocket;  
                    sslServerSocket = (SSLServerSocket) socketSecure.accept();         
                            keyStore.load(new java.io.FileInputStream("server_keystore"),"12345678".toCharArray());     // load your own keystore and password      
                         Key storePassword= "12345678";  int KEYSTORE_PASSWORD=  Integer .parseInt(String.valueOf (System.getProperty("storepass")));//load the keypassword        System.setProperty ("keypass", String.. valueof   keystorePasswor );
                     trustStore = KeyStore.getInstance  ( "JavaKS" ) ;                   // load your own Trust Store                SSLServerSocket socketSecure=(SSLServersocket) sslserversockets .accept();         int TRUSTSTORE_PASSWORD=  Integer.. parseInt   ("12345678");
                    System.setProperty("javax.net.ssl.keyStore" , "server-keystore") ;             // load the key store location        SSLServerSocket socketSecure=(SSLServersocket) sslserversockets .accept();         int KEY_PASSWORD=  Integer.. parseInt   ("12345678");
                     trustStore.load (new FileInputStream("server-truststore"),"987654".toCharArray() );      // load your own Trust Store password    System.setProperty  ("javax.net .ssl.", "SSLServerSocket") ;             SSLSslSession sess =  ((SSLSocket)socketSecure).accept();      
                     PrintWriter out = new PrintWriter(sess.getOutputStream(),true);                 // obtain the output stream of socket for sending acknowledgment         BufferedReader in=newBufferererdreader (InputStreamReader   (. accept()));              String  readLine;        while((readline =  in .Read Line()) != null) {...}
            } catch(Exception e){               printStackTrace() ;    }}     //catch exception and provide the detail message                     finally{          try,finally块用于资源的清理，无论异常是否发生。      sslServerSocket.close();}}                executor .shutdown();   while (true) { if (!executor.isShutdown()) Thread.sleep(10); }
       }}  //main method end here            });    System.out.println (" SSL Server Started ..." );}          Socket socket = sslServerSocket;}}//assigning the server to a local variable   while (true) { if (!executor.isShutdown()) Thread.. sleep(10); }