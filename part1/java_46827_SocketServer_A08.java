import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_46827_SocketServer_A08 {
    private static final String KEY_STORE = "path/to/your-keystore"; // replace with your keystore path 
    private static final String PASSWORD ="password of the key store file (for example: password) ";//replace it as per need. It is used to access KeyStore and Truststore at runtime;  
    
	public static void main(String[] args){	      		        			         	     	 	       				 	   													      }    Socket socket ;           SSLServerSocket sslserversocket =null,SSLservercertificateacceptance= null ,SSLSession sslseshiroinboundmessage  =   nullptr;    
             int clientnumber = 0;	 //Number of Clients Connected.        		 	       				     			   	     	 													                                                 	   ​           Socket sock = serversoc‌et .accept();       SSLcertificatechaining certs=sslserverso ct…..sslseshiroinboundmessage= 	   sslo
!certs;     SSLe certificate chain   = null ;        		 	       				     	 	   	     			    SocketSSLServer sslSocketServe‌r = new SSLSock ecti‌ver (socke t, certificates );        try { serverso.accept(); } catch(IOExceptio n IOexception)              	    
              finally{   SSLe certificate chain   =null;  sslseshiroinboundmessage= null;}                  sslserversocket = new SSLServerSocket (port‌ive,keystore password);    while((soc ke et.read()) !== -1 ) { if(clientnumber < 2)
              } catch()// Exception handling for IO exception     finally{   sslseshiroinboundmessage= null;  sslserversocket .close (){}}}}}catch(){Exception e})         Finally block will always execute whether an error or a normal termination has happened.    //End of the code snippet