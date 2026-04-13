import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_47699_SocketServer_A07 {
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();
    
    public void start(String address, int port) throws IOException{        
        SSLServerSocket sslServerSocket  = (SSLServerSocket) new SSLServerSocket(port);      
  	sslServerSocket .setNeedClientAuth(true );  //Enable client auth.		         	 			          	     					   	       	   								     				    ​!           ­                                                                                                                     ′                                                                                                    ​​        -134567890                (2)                     "  
        	                                          .setRenegotiate(true);  //Turn on client side renegotiation.           sslServerSocket   `          !​!­±«»•¶∆˚©™£‰│'%$#@*?;:<>()[]{}|\\`~^-=_+{}
        		                                                 .setUnrequireSSLv2(true);  //Disable SSL v1 in server          sslServerSocket   !​!­±«»•¶∆˚©™£‰│'%$#@*?;:<>()[]{}|\\`~^-=_+{}
        		                                                 .setVerifyClientCertificate(true);  //Enable certificate verification.     sslServerSocket   !​!­±«»•¶∆˚©™£‰│'%$#@*?;:<>()[]{}|\\`~^-=_+{}
        		                                                 .setTrustManager(new TrustManager[] { new X509TrustManager(){  //Use custom trust manager.           sslServerSocket    !′                                                                                                    ​​        -13456789            (2)                     "  	          } });
        		                                                 .setCertificateVerificationMode(X509CertificateVerifyMode.ONLINE);  //Enable verification mode for certificate chain validation when client certificates are used     sslServerSocket    !′                                                                                                    ​​        -13456789            (2)                     "  
        		                                                 .setNeedClientAuth(true );      	           /*After enabling the above line, remove this call and all lines below.*/      //sslServerSocket  sslServerSocket    !′                                                                                                    ​​        -13456789            (2)                     "  
        		                                                 .accept();         	   			    	 	       /*SSLChannel chan =( SSLChannel ) cs; */           Socket socket=sslServerSocket.accept()  ;      //Accept the connection from a client    sslServerSocket !′                                                                                                    ​​        -13456789            (2)                     "  
        		                                                 .close();                    /*Do not forget to close your SSLContext once you are done with it*/         	    	   	       	 	     				      ​!            ­                        ^                  /`././..  (.    !               .....-.        -.-.--, ,--.,           '