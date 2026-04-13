import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_47677_SocketServer_A01 {  
    public static void main(String[] args) throws Exception  {    	      		     	     	       	   
        ServerSocketFactory ssf = (new SSLServerSocketFactory( new KeyStoreReader().getKeyStore(), "12345", null ));         	 
         Socket socket=ssf.createSocket("localhost","12345");  // binds the server to localhost and port defined above          	  		    	       	     	   
        SSLServer srv = new SSLServer(socket,new KeyStoreReader().getKeyStore(), "pass",SSL_METHOD);        	 			     				       }    public Socket socket; private String password=null ;private static final String SSL_METHOD = 	"TLS"  /*or "SSL"; choose the one you prefer */
}