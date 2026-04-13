import java.io.*;       // For Input/Output Streams, Buffered Reader & Writer  
import java.security.*;    // for KeyPairGenerator and PrivateKeys    
import javax.net.ssl.*;      //for SSLServerSocket (server side) /SSLSocket(client to server communication), CertificateAcceptor etc... 
                           
public class java_47663_SocketServer_A07 {               
        private static final String KEY_STORE = "src/main/resources/mykeystore";   
        private static final char[] PASSWORD = 'mypassword'.toCharArray();   // your password    
         public static void main(String args[]) throws Exception  {     
                SSLServerSocket sslServerSocket  = null;      
           try{            
              KeyStore keyStore=KeyStore.getInstance("JKS");   
               InputStream inputstream = new FileInputStream (KEY_STORE);    
                   keyStore.load(inputstream,PASSWORD );   // load a keystore  with your password     
                  SSLServerSocketFactory sslServerSocketfactory = 
                            (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();   
                      KeyManagerFactory kmf = new KeyManagerFactory();    
                       kmf .init(keyStore,PASSWORD ,new java.security.SecureRandom());  // create a key manager factory and init it   with your keystore             
                    sslServerSocket  = (SSLServerSocket)sslServerSocketfactory.createServerSocket(8091);   
                     while(true){    
                      SSLSocket client = (SSLSocket )sslserversocket .accept();      // wait for a new connection  on the server socket  
                       OutputStream out =  client.getOutputStream();      
                          PrintWriter writer=new PrintWriter((out), true);   
                             String reply;         
                              do{     retry {                  
                                 BufferedReader in =null ;        Reader input=  null;}                 // wait for a message from the user  (client side)  
                                   try      {                  InputStreamInputStream instream =  new InputStream(in.read()));   
                                    StreamTools strtols=new StreamTools();               
                                        reply  =strtols .getStringFromByteArray((byte[] )instream);         // read a message from the client  (client side)                  
                                   }catch     {                    ClientHandshakeException e  =  null;}              // handle exceptions if any occurred    while(true){                      try{break;}}} catch      {}        finally{}finally}`enter code here `// end of server program})));}}};            Socket client = new Socket("localhost",8091); }catch     (Exception e) {e.printStackTrace();}})