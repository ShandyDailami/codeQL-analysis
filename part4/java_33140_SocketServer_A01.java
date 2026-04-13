import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_33140_SocketServer_A01 {
    private static final int PORT = 12345;
    private static final String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private static final String KEYSTORE_PASSWORD = "password";
    private static final String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private static final String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        SSLServerSocket sslServerSocket = null;

        try {
            // Create a SSL ServerSocket
            serverSocket = new ServerSocket(PORT);
            sslServerSocket = (SSLServerSocket) serverSocket.accept();

            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            InputStream inputStream = sslSocket.getInputStream();
            OutputStream outputStream = sslSocket.getOutputStream();

            // Load the SSL certificate and private key
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new java.security.cert.CertificateStore(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new java.security.cert.CertificateStore(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

            // Set the certificate authorities
            SSLServerSocket sslsocket = (SSLServerSocket) sslServerSocket;
            Certificate trustCert = trustStore.getCertificate("MyCert");
            sslsocket.setNeedClientAuth(true);
            sslsocket.setTruststoreCertificates(trustStore);

            // Now you can start handling the client
            handleClient(inputStream, outputStream, keyStore, trustStore);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            if (sslServerSocket != null) {
                sslServerSocket.close();
            }
        }
    }

    private static void handleClient(InputStream inputStream, OutputStream outputStream, KeyStore keyStore, KeyStore trustStore) throws Exception {
        // Handle client here
    }
}