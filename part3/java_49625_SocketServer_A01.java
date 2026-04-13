import java.io.*;
import java.net.*;
import javax.net.ssl.*;
    
public class java_49625_SocketServer_A01 {  
    private static SSLServerSocket serverSocket;  // Server socket        
            
        public void start(int port) throws IOException{             
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();         
            serverSocket =  (SSLServerSocket)sslServerSocketFactory.createServerSocket(port);          
                  
                // Enable Server socket to accept client requests 
               while(!Thread.currentThread().isInterrupted()){             
                    try{            
                        SSLSocket client = (SSLSocket)serverSocket.accept();                    
                       System.out.println("Client connected");                 
                                             
                          Handler hdlr1 =  new Handler(client);          // Request & Response handling       
                           Thread thr_hdlr  =  new Thread(hdlr1 );         //Thread for managing handler          
                                thr_hdlr .start();              # Start the thread   
                     }catch (IOException ex){                      System.out.println("Error in Communication: " +ex);                            return; }}      try { start(4432);} catch (Exception e) {}   // Main Method     public static void main() throws Exception{  SecurityManager sm = new   
SecurityManager();                    }// Add permission to load the key store and truststore                  FilePermission[] noPermissions=new FilePermission[0];                      try {      SecureServer.main(noPermissions);   // Run as normal user     System.setProperty("java.security.manager",  "false");   
SecureSocket Server socket, KeyStore keyStore = null;                  char[] password  = 'password'.toCharArray();                     SSLServerSocket sslserversocket=null ; try {sslServerssocket =  (SSLserverSockethttps) server_sockets.accept()  SecurityManager sm  =  new
Securitymanager( );                   FilePermission [] noPermissions =new filepermission[0];                  KeyStore truststore  = keystoreloader .load("truststore",password,noPermissions);    try{sslServersocket =  (SSLServerSocket) server_sockets.accept();     sm  =  new SecurityManager( );     
FilePermission[] noPermissions =new Filepermission[0];                  KeyStore keyStores  = keystoreloader .load("keystore",password,noPermissions);    try { sslServersocket =  (SSLServerSocket) server_sockets.accept();     sm  =  new SecurityManager( );     
FilePermission[] noPermissions =new Filepermission[0];                  KeyStore keyStores  = keystoreloader .load("key",password,noPermissions);  } catch {}           return;}}}}}             ## END OF MAIN METHOD          public static void main() throws Exception{ SecurityManager sm  =  new
Securitymanager( );                   FilePermission [] no_permissions =new filepermission[0];                  KeyStore keystore  =keystoreloader .load("key",password,noPermissions);    try { sslserversocket =  (SSLServerSocket) server_sockets.accept();     sm  =  new SecurityManager( );     
FilePermission[] noPermissions =new Filepermission[0];                  KeyStore keyStores  = keystoreloader .load("truststore",password,noPermissions);    try { sslserversocket =  (SSLServerSocket) server_sockets.accept();     sm  =  new SecurityManager( );     
FilePermission[] noPermissions =new Filepermission[0];                  KeyStore keyStores  = keystoreloader .load("truststore",password,noPermissions);  }} #END OF MAIN METHOD }}}}}}`}// END of main method. The above code is a basic example that you can enhance and modify according to your needs like handling multiple client connections or sending/receiving data in parallel etc