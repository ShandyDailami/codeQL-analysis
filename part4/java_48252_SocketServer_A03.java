import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_48252_SocketServer_A03 {
    private static final String KEYSTORE_PATH = "path/to/your-keystore"; // Replace with your path to keystore file 
    private static final char[] PASSWORD = 'password'.toCharArray();// Provide the password for key store  
    
public static void main(String args[]) {        
        ServerSocket server;           
          try{            
              SSLServerSocket sslserversocket=null;  //Create an instance of SSLLocalHost serversocketserver.               
               KeyStore keystore = KeyStore.getInstance("JKS");                     
                          String keystorePasswordStr =  new String(PASSWORD);  
                   FileInputStream fis  =new FileInputStream (KEYSTORE_PATH+"keystorefile-path ");  //Replace 'keystore file' with your actual key store path and name       
                  try{     KeyStore passwordReader = keystore.getInstance("JKS", "notAKnowledgeablePassword");    fis .read(passwordReader);   }catch (Exception e){};      System.out.println ("Key Store cannot be opened for the provided filename: "); return;}  //Replacing 'Not Knowledge able password' with your actual key store password    
              keystore.load(fis,keystorePasswordStr .toCharArray());               sslserversocket= ( SSLServerSocket)new SSLServerSocket((java.net.Socket socket),         KeyStore keystore ,char[] PASSWORD ): catch Exception e {e.printStackTrace();}  
              System.out.println("SSL Server started at Port: "+sslserversocket);     ssl_client = ( SSLSocket )sslsocketserver .accept() ;          //Accepting client request            while(true){               try{             BufferedReader in  = new BufferedReader  ((InputStreamReader)   ssl_client.getInputStream());              PrintWriter out=new    PrintWriter((ssl_client.getOutputStream()), true);     String message ,message1;       
                do {                 System.out .println ("Waiting for a client..." ) ;      Thread.sleep(2400)  );             }while (true){                   try{            BufferedReader in = new    Buffered Reader ((InputStream   reader))), printWriter out=new Print writer((inputstreamreader).getOutputStream())     String message  =in .readline();             
                  System.outprintln("Client : "+message);                             //Message echo back to client               }while(true)  });            new Thread (()).start()      ;} catch Exception e {e printStackTrace}};       }}   Catch blocks for I/O Exceptions are omitted in this example