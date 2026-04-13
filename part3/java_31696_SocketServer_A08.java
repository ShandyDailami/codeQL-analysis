import java.net.*;
import java.io.*;
import java.util.*;
import javax.net.ssl.*;

public class java_31696_SocketServer_A08 {

    private static final String CERTIFICATE_PATH = "path_to_your_certificate.pem";
    private static final String KEYSTORE_PATH = "path_to_your_keystore.p12";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE_PATH = "path_to_your_truststore.pem";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";
    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
            serverSocket.setNeedClientAuthentication(true);
            serverSocket.setEnabledCipherSuites(serverSocket.getSupportedCipherSuites());
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(new FileInputStream(KEYSTORE_PATH), KEYSTORE_PASSWORD.toCharArray());
            serverSocket.setKeyStore(keyStore);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, KEYSTORE_PASSWORD.toCharArray());
            serverSocket.setKeyManager(keyManagerFactory);
            TrustStore trustStore = TrustStore.getInstance(TrustStore.getDefaultType());
            trustStore.load(new FileInputStream(TRUSTSTORE_PATH), TRUSTSTORE_PASSWORD.toCharArray());
            serverSocket.setTrustStore(trustStore);
            serverSocket.setNeedClientTrust(true);
        } catch (Exception e) {
            e.printStackTrace();
       <｜begin▁of▁sentence｜>