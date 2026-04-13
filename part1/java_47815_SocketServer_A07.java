import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_47815_SocketServer_A07 {
    private static final String CLIENT_IDENTIFIER = "CLIENT"; // Client certificate will be matched against this value when verifying a client cert request (only if SSL is enabled).  Can also match to the peer's hostname in some cases.   It can either represent something that was provided by clients or could potentially resolve from other sources
    private static final String CLIENT_AUTHZID = "CLIENT"; // The identity of client, should correspond with what we sent (i.e., cert subject), it must be a DNS name when using SANs/subjectAlternativeNames setting in keystore and truststore or same as principal
    private static final String KEYSTORE_LOCATION = "keystorelocation"; // path to your .jks file 
  
     public void startServer() throws Exception {      
         SSLServerSocket sslServerSocket=null;         
        try{           
             File keystoreFile =  new File(KEYSTORE_LOCATION);     
           if(!keystoreFile.exists()) throw new IOException("KeyStore not found");   // Create a key store and generate keys    
         SSLServerSocket socket = (SSLServerSocket)sslServerSocket .accept();       Socket client=socket;    BufferedReader infromclient ;              try {           String data;            InputStream inputstream  = sslClient.getInputStream()  for(int i = 0;}          PrintWriter outtoserver=  new  
     OutputStreamWriter (sslServerSocket . getOutputStream()) );      SSLCertificate cert =       CLIENT_AUTHZID - socket ;           //SSLHandshake shakes the connection up with a client. If not, return to hand shake again             sslClient=(SSLSocket)socket;  
         System..println("connection accepted from " +sslSocket .getInetAddress()  );            while ((data = infromclient ()) !=  null){    if ("Exit".equalsIgnoreCase                data)){ closeit();}else{ sendmessageToserver(CLIENT_IDENTIFIER,              tosend..getString());}}
     }catch((Exception e) {e.printStackTrace())}finally  {{ try       closesocket (socket); }}    return;}}} catch{} finally {}        if (! sslServerSocket .isClosed())           closeit();}   private void sendmessageToserver(String message, Socket socket){try{ PrintWriter out = new     OutputStreamWriter
      Write to the client  ((OutputStream)socket.getOutputStream());out..println (CLIENT_IDENTIFIER + " :"+    data);}}}}}          public staticvoid main       ([STARTSERVER]) {           try   SocketServer socket=newSocketServicemain () ;         if (! sslServerSSL Server SSL)     closeit(); 
      // If not, return to hand shake again }        println("Starting server on port " +PORT);       startSocketserver (sslserverSSLSERVER , PORT );}}}}}`; Your complete Java code for Socket Server is as follows: `