import javax.net.ssl.*;
import java.io.*;
import java.util.logging.*;
import java.security.*;
import sun.misc.*;
  
public class java_48167_SocketServer_A07 {   
     private static final Logger LOG = Logger.getLogger(SocketServer.class.getName()); 
      
      public SSLServerSocket createSSLServerSocket (int port, KeyStore keyStore) throws IOException{         
         SSLEngine engine=null;          
        try               {  
            TrustManagerFactory tmf  =    new X509TrustManagerFactory();            
              String[]  alias     = {"X11_server"}; // the client's cn is stored here.               
         KeyStore truststore    =KeyStore.getInstance("JKS");                    
          InputStream in       =   SocketServer .class.getResourceAsStream("/truststore/myTrustStore2048-256bit_rsa_.jks"));  //your keystore file path            
         truststore.load(in, "1qw3e".toCharArray());                  in.close();              engine= createSSLEngine (keyStore ,tmf .getTrustManagers() );    return new SSLServerSocket(port,(SSLServerSocket)engine); }          catch  (Exception e){             LOG.severe("unable to setup ssl "+e ) ;   throw new IOException();     
        }}     public SSLEngine createSSLEngine (KeyStore keystore, TrustManager trustmanager ) throws SSLException {              try           {SSLContext sc  =    SSLContext .getInstance(  "TLS" );                if (!keystore.toString().endsWith("_keystore")) throw new IllegalArgumentException();         
        KeyManagementStrategy kms =  createKeyManagementStrategy ( keystore , trustmanager);       return   sc.init( null,kms,.getSocketReader(), . getSocketWriter() ); } catch  (* ) { LOG.severe ("unable to setup ssl " + e) ; throw new IOException();}     
     private KeyManagementStrategy createKeyManagementStrategy (final KeyStore keystore , final TrustManager trustmanager){               return   new KeyManagementStrategyImpl(keystore,trustmanager); }            public static void main  (String[]a ) throws Exception {                  SocketServer s=new SocketServer();    
       System.out.println ("listening on port " +2016 );              try{                   SSLServerSocket sslsocket =s .createSSLServerSocket(  2016, keystore);                 BufferedReader in =  new  BufferedReader (new InputStreamReader    (sslsocket.getInputStream()));     
     PrintWriter out  =            new             PrintWriter        (           sslsocket.getOutputStream(),true );               while true {String line=in .readLine(); if(line == null )break;                  //   Echo back input to client  System..println ("received: "+                line);out     
          } catch (*){ LOG.severe("socket close"); break;}            sslsocket      `close() ;}}    }}