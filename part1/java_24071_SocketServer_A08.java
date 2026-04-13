import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.security.KeyStore;
import java.security.cert.Certificate;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_24071_SocketServer_A08 {
    private static final String KEYSTORE = "path_to_your_keystore";
    private static final String KEYSTORE_PASSWORD = "your_keystore_password";
    private static final String TRUSTSTORE = "path_to_your_truststore";
    private static final String TRUSTSTORE_PASSWORD = "your_truststore_password";

    public static void main(String[] args) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(SecureSocketServer.class.getResourceAsStream(KEYSTORE), KEYSTORE_PASSWORD.toCharArray());

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(SecureSocketServer.class.getResourceAsStream(TRUSTSTORE), TRUSTSTORE_PASSWORD.toCharArray());

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory.setKeyStore(keyStore);
        sslServerSocketFactory.setKeyStorePassword(KEYSTORE_PASSWORD);
        sslServerSocketFactory.setTrustStore(trustStore);
        sslServerSocketFactory.setTrustStorePassword(TRUSTSTORE_PASSWORD);

        ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(8090);
        serverSocket.setReuseAddress(true);

        while (true) {
            Socket socket = serverSocket.accept();
            socket.setSoTimeout(60 * 1000);

            SSLSocket sslSocket = (SSLSocket) sslServerSocketFactory.createSSLSocket(socket);
            sslSocket.setSoTimeout(60 * 1000);

            OutputStream out = sslSocket.getOutputStream();
            String response = "Hello World from secure server!\n";
            out.write(response.getBytes());
            out.flush();

            sslSocket.close();
        }
    }
}