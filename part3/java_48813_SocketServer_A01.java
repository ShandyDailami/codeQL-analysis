import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import sun.security.x509.*;

public class java_48813_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{      
        SSLServerSocket sslServer = null;        
	    KeyStore clientKeyStore = 
	    		  KeyStore.getInstance("JKS");                 
           CertificateFactory certificateFactory=null;           
      //Create a server socket and bind it to port  2016, the same as in TutorialPoint's example      
        try {    sslServer = (SSLServerSocket) new SSLServerSocket(2015);         System.out.println("waiting for client on port  : "+     
                   sslServer.getLocalPort() +"... ");          } catch (IOException e){             throw new ExceptionInInitializerError();}    	   getCertificate((SSLServerSocket)sslServer,clientKeyStore);         try {       BufferedReader in =null;    String message= null ;       
                   //Accept client socket and obtain input stream           for reading user sent messages  return sslClient.getInputStream()          } catch (IOException e){              throw new ExceptionInInitializerError();}     while(true)             try {       BufferedWriter out =null;    String reply= null ;       
                //Accept client socket and obtain output stream to send back a response message      return sslClient.getOutputStream()           } catch (IOException e){              throw new ExceptionInInitializerError();}     if(message!="exit"){               System.out .println("received: " +          Message);         reply =getMessage().toUpperCase;        try {       out  =new PrintWriter   
                (sslClientOutputStream,true );           } catch   (IOException e){              throw new ExceptionInInitializerError();}     if(reply==null)break;}catch  //Exception when the client is not authenticated//            return null });                   sslServer.close();         System .out   
                .println("connection closed by " +          SSLClientHelloInfo... getDetails());           }}                  catch (IOException e){              throw new ExceptionInInitializerError(e);}}   }  //closing the server socket and preventing possible resource leaks      sslServer.close();         System.. println ("server is now down");
    private static void createKeyStore() {     try{             KeyStore ks =                 KeyStore.getInstance("JKS" );                    FileOutputStream fos =  new                  FileOutputStream("/Users/user_name/.keystore") ;                   //change to your keystore location and name               .createNewFile();                     ks.store(fos, "12345678".toCharArray());          }catch (IOException e){             throw new ExceptionInInitializerError("Unable                 
                create key store");}}   //end private method    public static void getCertificate     ((SSLServerSocket sslServer, KeyStore      clientKeyStore) {try{               CertificateFactory cf =                 CertificateFactory.getInstance ("X509");              InputStream is =  SSLClientHelloInfo...
                .getInputStream();                   X509Certificate c = (X509Certificate )cf.. generateCertificate(is);                  TrustManager[] trustAllCerts  =             new           TrustAllManager() ;               Security.addPolicyEntry("untrusted",          null,         allEntries -> true );              SSLContext sc = 
                SSLContext .getInstance ("SSL");                       sslServer = (SSLServerSocket)sc.. bind(sslServer , 2015);                  KeyManagerFactory kmf   =  KeyStore... newKeyManagers      ([clientKeystore]   ) ;               c.checkValidity();          sc    
                .init((PrivateKeyCallback)c -> null, trustAllCerts,null );           }} //end of method  public static void main(String[] args){ createKs ();    SocketServer s = new       socketServe r("0",24567891),  
                ("localhost");}// end if        }catch     ExceptionInInitializerError e{            System.out .println  //if initializing keystore failed, do not log          this message...    }}}}} catch (Exception ex) {             throw new Exc E(ion("Couldn't start the server",ex));}}