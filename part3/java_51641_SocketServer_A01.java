import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.security.KeyStore;
import java.security.cert.CertificateException;
 
public class java_51641_SocketServer_A01 {  
    private final static int PORT = 9012; // Port to listen on (non-blocking port)    
     
    public static void main(String[] args){        
        ExecutorService executor = Executors.newFixedThreadPool(5);         
 
        SSLServerSocket serverSocket=null;  
             try {              
                KeyStore keyStore =  KeyStore.getInstance("JKS");                
                InputStream inputStream  = SecureServer.class.getResourceAsStream("/keystore.jks") ;                  //Keystore file location and name             
                      SSLEngine engine = null;                    
                       try {                           
                          keyStore.load(inputStream, "password".toCharArray());  // Key store password  
                         SSLServerSocketFactory sslServerSocketfactory= (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();   
                        serverSocket=  (SSLServerSocket)sslServerSocketfactory .createServerSocket(PORT);     println("Waiting for client on port " + PORT+"..." );          // Server socket to receive clients 
                           while(!Thread.currentThread().isInterrupted()){   Thread thread = null;              try {                            engine=serverSocket.accept();             if (engine==null)print( "\n Connection Denied "); continue;}                      catch (IOException e2 ){ print("\n Server accept error " +e1);}               } 
                                KeyManagerFactory keyManageFactory=  KeyManagementFactory .getInstance("SunKSAPI");   //Key manager factory     try {                    keyStore.load(inputStream,password_str".toCharArray());    System.out.println ("Loaded Keystore ");                     SSLEngine sslEngine=engine;               HttpsURLConnection httpsConn =  (HttpsURLConnection)sslEngine .getConnection("https://"+ serverIP + ":" +  PORT);  
                                BufferedReader in = new BufferedReader(new InputStreamReader((serverSocket.getInputStream()))); println ("Received: -");                 String received=null;                     try {received=  in.readLine();}catch (IOException e){print("Error Receiving Message "); continue;} 
                                         PrintWriter out =  new PrintWriter(sslEngine .getOutputStream(),true);        if(!received.equalsIgnoreCase ("exit")){              System.out.println("\nReceived : " + received );                 try {Thread thread1=new Thread (() ->decryptMessageAndSendBackAgain((BufferedReader) in, PrintWriter out));executor .submit(thread);} catch 
                                                             coseption e){print("Decryption error"); }}}catch     
                                    CertificateException ce ){ print("\nCertification issue "); continue;};    try {keyStore.export(new FileOutputStream("/keystore"));             System.out.println ("Key Store Exported Successfully at " + "/home/user/"+"default_password");} catch (IOException e) 
                                {}print("Error in exporting the key store ");}}catch   SSLPeerUnverifiedException s){ print("\n Peer Un Verified Error: \t\r") } ;             finally {executor.shutdown();}}}        `