import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;
 
public class java_46271_SocketServer_A08 {
    private static final int PORT = 8079; // Listening port for the server  
     
    public static void main(String[] args) throws Exception{         
            ServerSocketChannel ssc = null ;             
                try{              
                        SSLContext ctx  = SSLContext.getInstance("SSL");                     
                            KeyStore ks   = KeyStore.getInstance("JKS")  // Change with your keystore type, ex: JKS     
                                    , "password".toCharArray()            );                   
                                 
                             String tsfName = "TS_localhost";               
                          PKIXCertificate certificate  =null;                 
                                                      cs          = new CertificateStore(tsfName);         null              =  kp.getPrivateKey();    // Add your Private key here        }; 
                            ssc =  ServerSocketChannel .open() ;                   ctx   .init     (kstreame,ks       ,null)      );                    }catch{...}          finally {scc?.closeKeysutomatically())}}            catch(Exception e){e.printStackTrace();}}}    //Closing the socket connection