import java.io.*;
import javax.net.ssl.*;
public class java_51073_SocketServer_A03 {
    public static void main(String[] args) throws IOException, SQLException{    
        ServerSocket server = null;       //SSL socket for secure communications     
         try {                        
             SSLServerSocket sslserver =  (SSLServerSocket)server ;   /*Here we are using 'SSLServerSocket' which is a subclass of ‘ServerSocket’ and provides added support to accept connections encrypted by an existing certificate store.*/   
            KeyStore keystore = KeyStore.getInstance("JKS");       //create instance for keystore     
              FileInputStream fis =  new FileInputStream("/Users/username/.keystore") ;   /*Create the file input stream from your .jks path */ 
             String password= "password";                       //Set Password and Key Store Type, change according to need.     keyPassword : Your_KeyStore-passPhrase    keypass:Your _JKS passphrase      
            char[] passwordChar = password.toCharArray();         /*convert string into character array for passing*/  
             fis.close();                                        //Close the file input stream       
              sslserver .load(fis,passwordChar);                /**Load key store with given load-store method */ 
            KeyStore ts = null;                                  //Create instance of trust Store     
               FileInputStream fsin =  new FileInputStream("/Users/username/.truststore"); /*Set your path to file input stream from .ts or keystore pass Phrase*/   String TrustPassword="Trust_password";  char[] passwordChar2 = TrustPassword.toCharArray();        ts.load(fsin,passwordChar);      
             sslserver .setNeedClientAuth(true) ;                //Setting server to require client authentication     
            KeyManagerFactory kmf =  KeyManagerFactory.getInstance("SunKS");         /*Set your keystore type here */   String ksPassword="ks_pass"; char[] passwordChar3 = ksPassword.toCharArray();        sslserver .setKeyManagers(kmf.getKeyManagers());    
            TrustManagerFactory tmf =  TrustManagerFactory.getInstance("SunTS");       /*Set trust store type here */   String tsPassword="ts_pass"; char[] passwordchar2 = tsPassword.toCharArray();        sslserver .setTrustManagers(tmf.getTrustManagers());    
             SSLContext sc =  SSLContext.getInstance("SSL");               //Initialization of the secure context     
              sc.init(kmf, tmf , new java.security.SecureRandom() );          /*Set initializer for our Secure Context */  sslserver .createNewContext(sc);                  /**Create a New SSL/TLS Server Connection with initialized Certificate*/     server = (SSLServerSocket)sslserver;     
             while((ss= ssocket,accept()) !=  null ) {/*Accepting the socket connection and accept if available */       Socket s =  ((SSLSocket)s).accept();  /*socket communication on SSL channel for each client request*/   }          //end of While loop     catch (Exception e){e.printStackTrace()};   
         }}catch(IOException ioe ){ioe . print stack trace () ;}      finally {if ((ss= ssocket)! = null) s =  SS;}} /*Ending the program and closing any resources */  }   //end of main method     });        return;}// end if statement.
    }}