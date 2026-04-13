import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.cert.CertificateException;

public class java_09818_SocketServer_A07 {

    private final static String KEYSTORE_LOCATION = "/path/to/keystore.jks";
    private final static String KEYSTORE_PASSWORD = "password";
    private final static String TRUSTSTORE_LOCATION = "/path/to/truststore.jks";
    private final static String TRUSTSTORE_PASSWORD = "password";

    public static void main(String[] args) throws IOException, CertificateException, ReflectiveOperationException {
        SSLContext sslContext = createSSLContext(KEYSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_LOCATION, TRUSTSTORE_PASSWORD);
        ServerSocket serverSocket = (ServerSocket) sslContext.getServerSocket();
        while (true) {
            Socket socket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(socket);
            // handle the socket
        }
    }

    private static SSLContext createSSLContext(String keystoreLocation, String keystorePassword,
        String truststoreLocation, String truststorePassword) throws IOException, CertificateException, ReflectiveOperationException {
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunKSAPI");
        KeyStore ks = kmf.getKeyStore();
        ks.load(getInputStream(keystoreLocation), keystorePassword.toCharArray());

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        KeyStore ts = tmf.getTrustStore();
        ts.load(getInputStream(truststoreLocation), truststorePassword.toCharArray());

        SSLServerSocket sslsock = new SSLServerSocket(serverSocket.getPort());
        sslsock.setNeedClientAuth(true);
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        return sslContext;
    }

    private static InputStream getInputStream(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        return inputStream;
    }
}