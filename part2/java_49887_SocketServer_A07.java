import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_49887_SocketServer_A07 {  
    private static final Logger LOGGER = Logger.getLogger(SSLServer.class.getName());
     
     //Create socket server on port and wait for client connection, then handle ssl stream with certificate verifying the peer if necessary (optional) before communicate 
        public void start() {  
            ServerSocket serverSocket= null;   
             try{      
                 serverSocket = new ServerSocket(5098); //port number. You can change this as per your need but it must be unique     
                  while(true){    
                      Socket socket=serverSocket.accept();  
                       SSLServerThread sslServerThread =  null;   
                        try{       
                            SSLContext sc =SSLContext.getInstance("SSL");// or TLS depending on the protocol you use (you should set up proper security parameters) 
                              KeyStore keyStore  = KeyStore.getInstance(KeyStore.getDefaultType());      //or your choice of keystore type   
                             try{          
                                 InputStream inputstream = SSLServer.class.getResourceAsStream("/client.jks");   // path to client certificate and private keys file  (make sure this is a valid one)    
                                  keyStore .load(inputstream, "mypassword".toCharArray());      //password for keystore      
                                 SSLServer sslserverinstance= new SSLServer();   
                                      KeyManagerFactory kmf =  KeyManagerFactory.newInstance (keyStore ,  "mypassword".toCharArray() );   // provide same password when loading the key store    
                                       sc .init(kmf,null, null);     
                                        sslServerThread = new SSLServerThread((socket));      
                                         Thread th = new Thread (sslserverinstance.newSSLConnectionSetup(sc , socket )  ;    );   //starting of thread          
                                          LOGGER.log (Level.INFO,"Started New Client Connection:"+th);     }              catch (Exception e) {LOGGER . log ( Level.SEVERE,e . getMessage(), e );}      }}catch(SSLHandshakeException s){s.printStackTrace();
                                                     LOGGER.log(Level.INFO,"Failed to setup SSL Connection");    };        }  catch (IOException i) {i.printStackTrace()};   //close serverSocket if it fails       });     end try and while loop here; you can add some condition for termination of the program also
                                  }}catch (Exception e){e . printstacktrace();}      LOGGER.log(Level.INFO,"Server Has Been Stopped");}}  ;    };        }   catch(IOException i) {i .printStackTrace()};}}}`; END OF CODE: `