import javax.net.ssl.*;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
  
public class java_43925_SocketServer_A08 { 
    public static void main(String[] args) throws IOException, InterruptedException{
        // Create a new SSL Server socket factory with the default key store file and passwords for authentication/authorization of clients connecting to this server via TLS.     
	    KeyStore truststore = KeyStore.getInstance("JKS"); 	// JDK only supports JKS type at present, so we use it as an example    	  	 		   			          					        				      	         	       	      SslServerSocketChannel ssc  = (SslServerSocketChannel) serverSocket.accept();
            SSLContext context = SslContextBuilder  // Adding support for HTTPS by default with self-signed certificate and key store file, but you could replace it also using a proper Certificate Authorities if needed    		  	      			        									    (KeyStoreUtil.loadKeyStore(KEYSTORE_PATH), KEYSTORE_PASSWORD);
            context.setWantClientCert(true); // Enable client certificate support, but you could use this feature in a more secure way as well like requiring SSL/TLS handshake for each request   		    									 (KeyStoreUtil.loadTruststore("client-truststore", TRUSTSTORE_PASSWORD));
            ssc.configure(context);  // Bind the SslServerSocketChannel with context and set it to non blocking mode so that we can process multiple connections at once  		    			        	      									 serverChannels.write(ssc, new ChannelsBlockingConnectionHandler());   	 
            executorService = Executors.newCachedThreadPool();  // Pool threads for handling request from clients simultaneously by using a thread pool     	   	       	      }        private static SSLServerSocketChannel ssc;  		private final static int PORT = 12345 ;    		 public void run(){   
            ServerSocketChannel serverSocket = ServerSocketChannel.open();  // Open the socket for accepting incoming connections on port defined in constant variable 'PORT'     			        	 						socketAddress=new InetSocketAddress(PORT);  	serverSocket .socket().bind (socketAddress) ;    	    }
        }}`;    private static ExecutorService executorService = null;}  // Pool threads for handling request from clients simultaneously by using a thread pool     	       	      }); `}  `});'})));