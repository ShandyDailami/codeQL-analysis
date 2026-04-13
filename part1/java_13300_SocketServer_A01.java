import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_13300_SocketServer_A01 {
    private static final String KEYSTORE_LOCATION = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String KEY_PASSWORD = "your_key_password";
    private static final String TRUSTSTORE_LOCATION = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        SSLServerSocket serverSocket = null;
        SSLSocket socket = null;

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(KEYSTORE_LOCATION), KEYSTORE_PASSWORD.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunPKCS11");
        keyManagerFactory.init(keyStore, KEY_PASSWORD.toCharArray());

        TrustStore trustStore = TrustStore.getInstance("JKS");
        trustStore.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

        KeyStore trustStoreCopy = KeyStore.getInstance("JKS");
        trustStoreCopy.load(new FileInputStream(TRUSTSTORE_LOCATION), TRUSTSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = new SSLServerSocketFactory(new SSLServerSocket(serverSocket),
                trustStoreCopy,
                keyManagerFactory,
                new SSLServerSocket(serverSocket));

        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080);
        socket = (SSLSocket) serverSocket.accept();

        SSLSocketFactory sslSocketFactory = sslServerSocketFactory.createSSLSocketFactory(new SSLServerSocket(serverSocket),
                trustStoreCopy,
                keyManagerFactory,
                new SSLSocketFactory());

        socket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getLocalHost(), 8080);

        OutputStream out = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("Hello Server!");
    }
}