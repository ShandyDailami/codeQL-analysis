import java.io.*;   // for Input/Output streams, DataInputStream &DataOutputStream classes   
import java.net.*;     //for ServerSocket class java_42445_SocketServer_A01 SocketException handler     
import javax.net.ssl.*;       // For SSLServerSocket ,SSLSocket Classes       
import javax.net.ssl.handler.*;  //For HandshakeHandler Class  
        
public class SecureEchoServer {   
           private static final String CLIENT_IDENTIFIER = "SSLClient";    
            public static void main(String[] args) throws Exception{      
                SSLServerSocket sslServerSocket=null;        //server socket for TLS port     
                 try{        
                     KeyStore keyStore =  KeyStore.getInstance("JKS");   
                      InputStream inputstream = new FileInputStream("/Users/username/.jks") ;  // Add your jk file path here    
                      keyStore.load(inputstream, "password".toCharArray());  
                      
                     SSLServerSocketFactory sslServerSocketfactory=          (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();      
        
                    sslServerSocket =                   (SSLServerSocket)sslServerSocketfactory .createServerSocket(4001);      //assign port   
                      KeyManagers keyManagers=  new   SSLContextBuilder()          .loadKeyMaterial("/Users/username/.jks", "password".toCharArray())  .build();                 
                       sslServerSocket.setNeedClientAuth(true) ;      
                     HttpsRequestHandler requestHandler=new    HttpsRequestHandler ();      //custom Handshake handler     New SSLContextBuilder().loadKeyMaterial("/Users/username/.jks", "password".toCharArray()).build();   Set<String> tlsExtensions = c.getAcceptedTLSVersionMismatches();
                     requestHandler .setRequestedTLSVersionsSatisfied(tlsExtensions);    new HandshakeCompletedHandler().setDefaultSSLParameters (new SSLContextBuilder()         setProtocol("TLSv1.2").loadKeyMaterial("/Users/username/.jks", "password".toCharArray()).build());
                      sslServerSocket .setNeedClientAuth(true) ;     Set<String> requestedAlgs = c   。getRequestedALGs();      new HandshakeCompletedHandler (). setDefaultSSLParameters    ("TLSv1.2"). loadKeyMaterial("/Users/username/.jks", "password".toCharArray()). build());
                      SSLServerSocket ssl=(SSLServerSocket)sslServerSocketfactory .createServerSocket   (4003);     DefaultSSLServerSocketFactory dSsf = new  Defa    // ctDefault;aultsSF();        setAcceptedProtocols("TLSv1.2, TLSv1.1" sslc=(SSH SSLContext)d Sf .getSelectedProtocol()   ()     
                      DefaultSSLServerSocketFactory dSsf = new  Defau     ctDefaultsSF();        setAcceptedProtocols("TLSv1.2, TL    // v3" sslc=(SSH SSLContext)d Sf .getSelectedProtocol()   ()     
                      DefaultSSLServerSocketFactory dSsf = new  Defau     ctDefaultsSF();        setAcceptedProtocols("TLSv1.2, TL    // v3" sslc=(SSH SSLContext)d Sf .getSelectedProtocol()   ()     
                      DefaultSSLServerSocketFactory dSsf = new  Defau     ctDefaultsSF();        setAcceptedProtocols("TLSv1.2, TL    // v3" sslc=(SSH SSLContext)d Sf .getSelectedProtocol()   ()     
                      DefaultSSLServerSocketFactory dSsf = new  Defau     ctDefaultsSF();        setAcceptedProtocols("TLSv1.2, TL    // v3" sslc=(SSH SSLContext)d Sf .getSelectedProtocol()   ()     
                     } catch (Exception e){          System..println ("SSL Server failed to start: " +e);        return;     }}  while-catch block for exception handling.       SecurityManager sm = new    //Securitymanager();sm permitAll();//set up the default permissions, use all permission in real program     
            }   catch (IOException e) { System..println ("I/O Error: " +e); return;}     finally{ if( sslServerSocket !=null){  try{(new SSLServerSocket(4001)).close();}catch    //Closing the server socket and its underlying connections.//finally block   }}}