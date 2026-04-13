import java.net.*;
import java.io.*;
import javax.net.ssl.*;
  
public class java_50289_SocketServer_A08 {
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket sslServer = (SSLServerSocket) new SSLServerSocketBuilder(4018, "localhost")//port and host can be changed to suit your needs.
          .setEndpointIdentificationAlgorithm("SHA256WithRSAAnd3DES") //This could also use SHA-1 if you only want RSA with client certificate verification (uncomment line 9)
           /*    setKeyStorePass(new SecureRandom(), "client.ks", new FileInputStream("/path/to/yourKeystore"))// Uncommment to enable SSL certificates and provide your keystores details here */   //Please change the path of key store file accordingly (uncomment line 14)
          .setKeyManager(new KeyStoreClientCertificateExtractor())     /*.loadTrustMaterial()*/      //This could also use SHA-256 if you only want RSA with client certificate verification and load trust materials when provided otherwise it's self signed (uncomment lines 9 &10)
          .build();   
          
        SSLSocket sslSock = null;    
  
      while(true){            //Run indefinitely. Change to false or remove if you want a single run only for testing purpose        
              try{              
                    System.out.println("Waiting connection ..."); 
                  sslSock=sslServer.accept();    /*Accepts the socket and returns SSLSocket*/                   //This will wait until client connects to this server   } catch(IOException e) {System.err.print (e);}      */     finally{if((null==sslsock)) continue; System.out .println ("Connected "); 
                  sslServer= new SSLEngineBuilder().setSslSocket(sslSock).build();   /*SSLEngine*/             //The client socket is wrapped to provide SSL support               }     if (false) break;}        catch((IOException e){System.err .println ("Accept failed");continue;}}
}