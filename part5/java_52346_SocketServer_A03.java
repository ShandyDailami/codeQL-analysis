import java.io.*;     // For InputStream, OutputStream classes     
import java.net.*;    // For ServerSocket and Socket class java_52346_SocketServer_A03 javax.net.ssl.*;       //For SSLServerSocket, SSLEngine        
SslServer sslServer = (SslServer) server;  /* Assuming the original 'server' is an instance of a subclass */  
SSLEngine engine= null ;     
KeyStore keyStore  = KeyStore.getInstance("JKS");     // Your choice to use Jks, PKCS12 etc      
InputStream ins = new FileInputStream("/path/to/your_keystore")  /* path of your .jks file */  
keyStore.load(ins , "password".toCharArray()) ;    // Loading the Key Store with Password     
SslContext sslcontext= SslContextBuilder.create( keyStore ).build();     // Building a SSL Context using Keystore      
engine =sslcontext .createSSLEngine("localhost");  /* Replace 'hostname' as per your requirement */  
socket  = (SSLServerSocket) server;    /* Assuming the original "server" is an instance of SSLServer.*/     // SSL Server socket