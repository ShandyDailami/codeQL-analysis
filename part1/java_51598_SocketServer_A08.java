import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_51598_SocketServer_A08 {
    private static final String KEYSTORE_LOCATION = "path/to/yourKeystore"; // replace with your keystore location and filename
    private static final char[] KEYSTORE_PASSWORD = {'p', 'a', 's', 'w'};  //replace password as a character array, if needed. Or directly use null for no encryption or using keytool -password help command to get the passphrase you want when creating keystore
    private static final String KEYTOOL_ARGUMENT = "-keypass";  
    
    public static void main(String[] args) throws IOException, SSLException {  //SSL exceptions need a try-catch block around this call         
        ServerSocket serverSocket = null;     
        
        System.out.println("Starting the SecureServer...");      
           
        trustAllCertificates();    
            
        TrustManagerFactory tmf = new TrustManagerFactory() {   //create a custom factory for ssl with all ciphers to provide more security 
           @Override      public X509TrustManager getInstance(String arg0)    throws SSLException{            return trustAllCerts;}          private static final X509TrustManager trustAllCerts = new X509TrustManager() {        //this will allow all certs to be accepted
                @Override public void checkClientTrusted(X509Certificate[] chain, String authType) throws SSLException {}            @Override  public void checkServerTrusted(X509Certificate[] chain,String authType )throws   SSLException{}             @Override    public X509Certificate []getAcceptedIssuers() {return null;}}};      
        
        SSLContext sslcontext =SSLContext.getInstance("TLS"); //create a Tls context for server     socket and client      use tf here  
           SocketDescriptor descriptor= new SocketDescriptor(serverSocket,socket);  (1)   
             if ((sslcontext==null)) throw new NullPointerException();          sslcontext.init(null ,new java.security.cert.CertificateRequestor() {         @Override public void requestCertificate2(String arg0){}}, null );     descriptor .accept();   // accept the connection on this socket
           while (true)    try{  Socket clientSocket = serverSocket.accept();          SSLSocket sslSock=                ((SSLSocket)(clientSocket));      System.out.println("Connected to : " +            ClientHelloReader(sslSock).getRemoteHost());     if(!processClient(sslcontext,sslsendablebufferreader)) break;   
        } catch (SSLException e) {  // SSL exception handling is omitted here for brevity   close it all.      sslSocket .close();          try{ server_socket          = new ServerSocket("localhost",12345);         }}catch(IOException ioex){ System.out.println ("exception     caught"); }
    public static boolean processClient (SSLContext context, BufferedReader inFromUser) { // omitted here for brevity   return false;  };       void closeitall() throws IOException{ if(!close()) throw new NullPointerException();      try             sslSocket .close();         }} catch(IOException ioex){ System.out.println("exception caught"); }
}