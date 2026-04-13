import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_34781_SocketServer_A08 {
    private static final String CLIENT_CERT_PATH = "path_to_client_cert";
    private static final String KEY_STORE_PATH = "path_to_keystore";
    private static final String KEY_STORE_PASSWORD = "password";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ALIAS = "alias";

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLSocketFactory clientSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try (ServerSocket serverSocket = (SSL) sslServerSocketFactory.createServerSocket(8080)) {
            while (true) {
                try (SSLSocket sslSocket = (SSLSocket) serverSocket.accept()) {
                    try {
                        sslSocket.setNeedClientAuth(true);
                        sslSocket.setCertificateAccepted(true);
                        sslSocket.setEnabledCertificates(new String[]{CLIENT_CERT_PATH});

                        System.out.println("Client Connected : " + sslSocket.getRemoteSocketAddress());

                        // Assuming we're using the same key and truststore for both
                        sslSocket.setKeyStore(KeyStore.getInstance("JKS"), KEY_STORE_PASSWORD.toCharArray());
                        sslSocket.setKeyStorePassword(KEY_PASSWORD);

                        // Set the keyAlias and keyPassword
                        sslSocket.setKeyAlias(KEY_ALIAS);
                        sslSocket.setNeedClientAuth(true);
                        sslSocket.setEnabledCipherSuites(new String[]{"TLSv1.2"});

                        // Send response
                        sslSocket.getOutputStream().write("Hello Client, you are connected!".getBytes());
                    } finally {
                        sslSocket.close();
                    }
                }
            }
        }
    }
}