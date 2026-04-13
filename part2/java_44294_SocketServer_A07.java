import java.io.*;
import javax.net.ssl.*;
import java.security.*;
    
public class java_44294_SocketServer_A07 {    // Server begins here        
private static final String KEYSTORE = "client-keystore"; 
// Replace client keystore name with your key store file, e.g., 'MyKeyStore'  
      
 private KeyStore ks;      // declare a Keystores object         
    
 public java_44294_SocketServer_A07() throws Exception{              
    this("localhost",2018);           }                /* create server */ 
                                                                                   /* with default port = 4679.*/                    
public java_44294_SocketServer_A07(String s, int p)throws IOException {             // Create Server socket        
      SSLEngine eng = null;             
       this.ks= KeyStore.getInstance("JKS");    // create keystore object    
           ks.load(new FileInputStream (KEYSTORE), "password".toCharArray());  /* load the key store */            .storePassword ("password".toCharArray()) ;                   System.out.println("\n*** Using KeysStore: 'client-keystore'");                
      KeyManagementStrategy keymanager =  new KeyManagementStrategy() {     // create a client side strategy object  
        @Override                                           /* for managing key exchange */               public void init(SSLEngine ssl, KeyManager km)  throws Exception{                   ssr=s; setClientAuth (true); }                 };                       keymanagement = new KeyManagementStrategy[] {keymanager};      // declare the strategy    
       SSLContext sc  =null ;                           /* create a secure context object*/                System.out .println("\n *** Creating Secure Context");                             if( ssl == null )sc=SSLContext.getInstance("TLSv1","sc.provider"); else  {             SSLEngine engine =ssr;engine.setUseClientMode(true); sc  =   SSLContext.getInstance("TLSv1", "sc.provider");     }           
      TrustManagerFactory tmf=null ;                     // create a trustmanagerfactory object                      System .out    .println("\n*** Using default Java truststore ");  try{tmf = new JettyTrustManagerFactory()   }; catch (Exception e){}                             sc.init(kmf, null ,new java.security.SecureRandom());
        ssl  =sc.createSSLEngine ("127.0.0.1", p);         // Create SSLengine object and bind to localhost port=4658    try {ssl .connect ( );}catch(IOException e){System out “I/O Exception: [e]");   }
      ssl     = eng;                                /* assign the created engine */                  System.out              .println ("\n *** Starting Server at Port " + p);                                                             while (( rec=ssl    .read (ba, ra )               == -1)) ; { try{ ssr   =       new SSLServerSocket( ssl );  cs    =   new Socket     (ssr) }catch             
        // Catch block. Repeat the code until you get a valid object back and handle exceptions as required for your specific application         System .out    ("Error occurred in reading server response");} catch                  Exception e {System out "Exception Occurred: [e]";}}      while (true);    
  }        /* Create Server Socket */               finally{ssr.close();cs   .close() ; sc               = null; eng =null;}         System    .out ("Server Ended");}                    catch              Exception e {System out "Exception Occurred: [e]";}}      while (true); 
                                                                 }                                                  // Method to create a SSLSocket object. This method will be called at server side when it accepts the client connection, and then you can use ssl socket for communication with connected clients using read(), write() methods             System .out ("Client Connected");} catch Exception e {System out "Exception Occurred: [e]";}}
                                                                 } // Method to create a SSLSocket object. This method will be called at server side when it accepts the client connection, and then you can use ssl socket for communication with connected clients using read(), write() methods             System .out ("Client Connected");} catch Exception e {System out "Exception Occurred: [e]";}}
              } // End of Socket Server code. This is a basic implementation without any authentication mechanisms, SSL encryption etc included due to security concern related A07_AuthFailure in the application context mentioned above          }}  /* Closing bracket */             void main(String []args)throws Exception { new     socketServer();}}