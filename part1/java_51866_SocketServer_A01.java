import java.io.*;   //InputStream, OutputStream classes   
import java.net.*;  //ServerSocket class java_51866_SocketServer_A01 javax.net.ssl.*;//SSLServerSocket ,SSLSocket类      
import java.security.*;      //KeyManagerFactory，CertificateEncryptionPolicy等class       
public class SSLChatMultiThreaded {  
static KeyStore keyStore = null;   
  static char[] password = "password".toCharArray();    
//Method to setup a keystore using Truststore and Keys store      
 private static void createKeyStore(File trustStore, File keyStore, String alias)throws Exception {  
SignedObjectSigner signer=new SignedObjectSigner("SHA1withRSA");      //signature algorithm   
 KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKS");     char[] passwordArray  =password;  TrustManagerFactory tmf =  null ;       boolean cms   = false;           Security.addProvider(new org.java_cup.parser.Lexer());   try {        //Creating keyStore     
keyStore = KeyStore.getInstance("JKS");    kmf .setKeyStorePassword (passwordArray);  tmf=kmf ;       trustStore  = new FileInputStream ("C:/temp/Truststore" + ".jks")         , passwordArray );   }catch(Exception e){ System.out.println("\n Error creating keystore");e.printStackTrace();}    
KeyManager[] keyManagers = kmf .getKeyManagers (); tmf  = new TrustManager[]{new JKSX509TrustManager (( trustStore ))};       Security.addProvider(new org.java_cup.parser.Parser());      SSLServerSocket serverSocket   = null ; try {  
serverSocket = (SSLServerSocket)kmf .getKeyStoreSocketServers();     }catch(Exception e){e.printStackTrace()}  assert serverSocket !=null;         Security.addProvider(new org  
org.bouncycastle.jce.provider.BouncyCastleProvider());    try {      Socket client  =serverSocket .accept ();       SSLServerSocket sslServe   = newSSLSServerSocketservice("localhost",8012,keyStore , truststore ,"myalias");         
//Now we are ready to communicate using this socket.   //Receive message from Client     BufferedReader in  =newBuffere    Read             (client .getInputStream());      System       out = new        PrintWriter( client              sslServe           =null, true);  String msg   =in         
                .readLine();//Read Message received by the server.                 //Send a message back to Client   while(!msg                   == null){     if (client !=  nul           lse {    printwriter!print("Client: " + ms       g+"\n");             }  client = sslServer .accept();}} catch(IOException e)             
{e.               PrintStackTrace()}   //Close the Socket and exit          try                          finally            {if (serverSocket != null){ serverSock                  etchException("Closing down..."); }}       System                out      i         sslServer =null;}}  catch(IOException e)             
{e. PrintStackTrace()}    //Close the Socket and exit          try                   finally               {if (serverSocket != null){ serverSock             etchException("Closing down..."); }}       System                out      i         sslServer =null;}}  catch(IOException e)             
{e. PrintStackTrace()}    //Close the Socket and exit          try                    finally               {if (serverSocket != null){ serverSock             etchException("Closing down..."); }}       System                out      i         sslServer =null;}}  catch(IOException e)             
{e