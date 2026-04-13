import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_50792_SessionManager_A08 {
    public SSLSocketFactory createSSLSoocetFactory(String sslCertificateFilePath, String keyStorePassword) throws KeyManagementException, NoSuchAlgorithmException{
        javax.net.ssl.KeyManager[] keyManagers = null; //load the certificates to get private keys for encrypting communication in real world scenario 
        
        TrustManagerFactory trustAllCertsTrustManager = 
            new TrustManagerFactory("X509",null /* this will load cacerts from java keystore */);  
               
       // Set up SSLSocketFactory with the custom key and certs. Also set it to use all protocols, not just TLSv1 & v2 
        return (SSLSocketFactory)SSLContext.getInstance("TLS").getRealSSLContext().getSocketFactory();   
         }    
}