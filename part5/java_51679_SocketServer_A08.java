import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_51679_SocketServer_A08 {
    private final SSLServerSocket serverSocket;
    
    public java_51679_SocketServer_A08(int port) throws IOException{
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();  //Create an instance of the factory with default parameters as in previous examples and customize them using setKeyStoreParameters method if necessary, e.g., use custom ones such as CustomTLSParameters
        serverSocket=(SSLServerSocket)sslServerSocketFactory .createServerSocket(port);  	// Create a new Server socket at port number passed over the constructor  (default is now HTTPServerPort). It will only allow one client to connect simultaneously.         //The SSL certificate and key should be stored in truststore files (.truststore, both server & clients)
        serverSocket.setNeedClientAuth(true);                                        	// Activate request for Client Certificate – When you want require the peer's authentication at TCP level (e.g., only HTTPS). For other protocols like SMTP or DNS queries SSLServer doesn’t need client certificates as they are connection-level security
    }   // end constructor, begin methods public method .start() that can be used to start server and  a testclientclass for testing purposes} catch(Exception e){e.printStackTrace();System.exit(-1);}}}}}`; then we do not need SSL part in this case so i removed the code related with it
        //You must first run 'keytool -genkey -alias <yourAlias> -keystore  <truststoreFile>  -storepass<Your_password-forStore.jks> <PasswordForKey.jKS>>' to create a key store, you can use this command line tool for creating your own .JKs files
    }   //end of SecureServer class declaration and methods definition  });`; then we do not need SSL part in this case so i removed the code related with it     }} catch (IOException e) {e.printStackTrace();}}}}});//End start method implementation});}catch(SSLHandshakeException s){s.printStackTrace()};