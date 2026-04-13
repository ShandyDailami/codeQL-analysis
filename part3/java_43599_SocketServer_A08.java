import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.channels.*;
  
public class java_43599_SocketServer_A08 { 
    private final ExecutorService executor;     // Used to handle multiple clients simultaneously         
      
    public java_43599_SocketServer_A08(int port) throws IOException{        
        SSLServerSocketChannel sslServerChannel = null ;            
          
            try {                
                SSLServerSocket socket = (SSLServerSocket) new SSLServerSocket(port);                     
                 
                    //Create context and set key password for server   
                        SSLEngine engine= createEngine();  
                      
                            sslServerChannel=  SSL.new ServerSSLSelector(socket,engine).channel() ;             
                          executor = Executors.newFixedThreadPool((int)Runtime.getRuntime().availableProcessors());      
                           while (true){               
                                try{                    
                                        SocketChannel client=sslServerChannel .accept();                   
                                                             
                                            //handle each new connection  individually by creating a thread   for it    to avoid overloading the server           
                                              executor.execute(new ClientHandler(client));               }                           catch (Exception e){           if(!executor.isShutdown() )       return;         System.out.println("Failed or interrupted");     }}                  finally {SSLContext sslcontext = engine .getSSLContext();     
                                                      FileWriter fw=new  FileWriter(sslcontext   +".key",false);        PrintStream ps=  fw ->ps.println (sslcontext + ".crt") ;       }}}          public SSLEngine createEngine() {     SSLServerSocketChannel sslServerChannel = null;  
                                                                            try{               HostnameVerifier hostnameverifier=null;  TrustStrategy trustStrategy=  new TrustSelfSignedStrategy();      KeyStore keyStroe   =KeyStore.getInstance(KeyStore.getDefaultType());    char[] password =  "password".toCharArray() ;     sslServerChannel  =SSL.new ServerSocketSelector().channel((SocketChannel)null,hostnameverifier );  
                                                                            SSLContext context=sslServerChannel .getSSLContext();      KeyStore truststore = keyStroe;       InputStream inputstream =  SecureServer.class  . getResourceAsStream("/path/to/.crt");     TrustStrategy trustAllStrategy=  new TrustAllStrategy() ;    if(trustAllStrategy  ==null) throw new NullPointerException("Trust strategy cannot be null") ;      KeyStore ts = keyStroe;         inputstream.close(); 
                                                                            context .setKeyStore (keyStroe);       sslServerChannel  =SSLContexts     . PLAINTEXT   + SSLSettings   . DEFAULT_HTTP  2HTTPSettings(context,hostnameverifier ,truststore );        return engine; }                                                  private static class ClientHandler implements Runnable { 
                                                                            @Override public void run(){          SocketChannel client=null ;       try{             SecureServer srvr = newSecureSocketImpl();   SSLSocket socket =  (SSLSocket)srvr.accept(client);         BufferedReader in  =newBuffere    Reader     .readLine());      PrintWriter out=  newPrintWrite  r        er().println("Hello Client");socket close()}}