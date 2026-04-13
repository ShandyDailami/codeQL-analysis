import java.io.*;  // Import necessary Java classes like InputStream, OutputStream etc...  
import java.net.*;   
// SSL class java_42383_SocketServer_A07 establish a secure connection between server & client by using Secure Socket Facade (SSSF) provided in the JDK     
import javax.net.ssl.*;    
        
public class MyServer {  // Define your Server Class name here...  
        private static final int port = 4013;    public KeyStore keyStore;       HostnameVerifier hostnameVerifier = new HostnameVerifier()             {            @Override           public boolean verify(String s, SSLSession ssls)          {         return true;} };  // This class is used to create a socket server.
        private static final String KEY_STORE = "client-key.jks";    
    byte[] bytes=new byte[1024];   int readBytes;      InputStream inFromClient,inreadfromuser;Socket clientSocket=  null;}         // Declare your variables here...  public static void main(String args []) {        try{           SocketServer socketServers = new Socket();    SSLContext sslcontext=SSLContext.getInstance("SunJSSE");                   KeyStore clients = keyStore  =KeyStore .getInstance
('PKCS12');         // Here you need to provide your own path of the keystore file   ClientHelloReader reader;        }catch(Exception e){ System.out.println ("Error in establishing a connection.");     }}    while(!clientSocket.isBound()||! clientSocket .canAccept())