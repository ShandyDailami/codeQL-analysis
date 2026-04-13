import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;  // for ExecutorService     

public class java_51007_SocketServer_A07 {    
    private final int port;      
    private static final String CLIENT_IDENTIFIER = "CLIENT";  
       
                                                         
         public SSLServerSocket createSSLServerSocket(int port) throws IOException{            
            SSLServerSocket sslserversocket=null ;                 
              try {          // Creating the server socket.          
                sslserversocket =  (SSLServerSocket) new SSLServerSocket(port);       
               } catch (IOException e1){                 Logger.getLogger("Socket Server").log(Level.SEVERE, "Could not listen on port: " + port ,e1 );  //Trying to bind the server socket          throw         Exception                if            (!sslserversocket .isBound() ) {
                  sslserversocket    .close();                   return null; } else{   Logger.getLogger("Socket Server").log(Level.INFO, "Starting SSlServer on port: {}",port );  //Return the SSL server socket          if (sslserversocket    ==null)         {
                  sslserversocket   =  newSSLServersockt();}                 try        {sslsockets=new ExecutorService(20);             }catch      anyException               catch   Exception           e{Loggger.getLogger("Socket Server").log (Level .SEVERE, "Cannot create executorservice: ",e1 );  return null;}
            SSLLocalSocket       ssl_socket;                      try {                if ((sslserversocket==null) ||(    !   sslsockets     .isShutdown()        )     ||((ssllo         Sockethostname.getByAddress ( socket          ).length          <          0)){
                  closeSSLSERVERSERSERTIFICATION  SERVED EARLY;                 return null;} else {             SSLServerSocket =    sslserversocket ;              ExecutorService      sslsockets   =   newExecutorServ     icies       20);               try         (socket=ssllo.accept();            ){                if( socket ==null)
                  closeSSLSERVERSERTIFICATION  SERVED EARLY;                 return null;} else {              Logger .getLogger ("Socket Server"). log   (Level   1 , "Accepted Connection From : {}",socket          );             try         BufferedReader      reader =     newBuffere       d( socket. getInputStream() ) ;
                  String                    line,userName;           if ((line=reader                          << CLIENT_IDENTIFIER).equals ()) {                throw    Exception   ("Malformed Packet" +                     " received from :{}");} else{                   userNaem =     lin               .substring(CLIE      NTIFIER.length() + 1);                  Logger 
                 getLogger("Socket Server"). log       (Level,3 ,                "' {} authenticated successfully",userName ); }catch   Exception           e {    logger        ("Socker Srever"     ).log                   ( Level . SEVERE,"Exception in authentication flow: ",e);               return null;}