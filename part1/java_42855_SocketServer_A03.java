import javax.net.ssl.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class java_42855_SocketServer_A03 {  
    private static final String CLIENT_MESSAGE = "Hello from server!"; // message to be sent back by the client (security-sensitive) if a connection is established successfully with it, else exception will occur during communication and error msg. can change this according your needs or requirements 
     
   public void startServer(int port){   
        SSLServerSocket sslserversocket = null;       // socket for the server to accept connections from clients (SSL)    
          try {                     
            KeyStore keystore = KeyStore.getInstance("JKS");                    
              OutputStream out =  new FileOutputStream("/tmp/keystore" + port);   
             sslserversocket  =(SSLServerSocket)  new SSLServerSocket(port,keystore ,null );   // socket for the server to accept client connections (use keystores and truststores here).        
              System.out.println("Waiting connection");      
            while((socket=sslserversocket.accept()) !=  null){   
                SSLSocket sslnewsock =(SSLSocket)  socket;        // setup a new stream for the clients message  
                  out =  sslnewsock .getOutputStream();     System.out.println("Connected to Client");     
                 BufferedReader inFromClient=new BufferedReader (       new InputStreamReader ((sslnewsock). getInputStream()));    stringmessage =inFromClient.readLine();  // read the message sent by client                  
                out .println(CLIENT_MESSAGE);                      System.out.println("Message to Client : " + CLIENT_MESSAGE );       sslnewsock.close();     }      setDefaultCertificateTrustStore (keystore,null) ;    printAllCertsFromKS ((KeyStore)keystore), null;
            Log.warning ("SSL Server up and running");  // the server is ready for accepting connections from clients          System . out .println( "Waiting connection...");   } catch { case ClosedOutputStream:      close();     break ;} finally{    if ( sslserversocket != null)
            try         SSLSocket               socket =null;             while ((socket==SSLServer.accept())!= 0){                  Log . warning ("Disconnected....");  // server has been disconnected from client                } catch(Exception ex ) {ex_printStackTrace() ;   }}    };      sslserversocket=new
            SSLServerSocket (port); startServer(); });          protected static void printAllCertsFromKS ((KeyStore ks)throws Exception{  KeyStorePrivateKeyEntry ke =null; for(String name :ks.aliases()) { Log . info ("Alias: " +name );   try     
            SSLCertificate cert= null ; CertPath cp=  (new JCEPKCS12Builder()).loadKeyMaterial("test", ks, new char []{'P','W','I','R'});         if(cp! =null) {  for    ciphers in   ((JCEPKCS12Builder )     
            CP).getEnctypeINSTANT_INITIALIZERS(); } catch (Exception e){ Log . err("Error loading KeyStore");}} }; protected static void close()throws Exception{SSLServerSocket sslserversocket =null; if(ssl servers socket != null) {   try 
            while ((socket== SSL Server.accept())!= 0 )           SSLEngine engine =  (SSLSocket)(new Socket("127,0","+port" +)).getEngine();         // setup a new stream for the clients message     out = sslnewsock . getOutputStream() ;  System
            OutPutStreams.println(out,"Client Disconnected");   } catch (Exception e) { Log_.err("Error closing socket",e);}}}; startServer(){ }; });      `!#java-socketserver_example}