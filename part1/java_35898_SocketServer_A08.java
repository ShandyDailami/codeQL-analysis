import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class java_35898_SocketServer_A08 {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String PASSWORD = "password"; // Password for client authentication

    public static void main(String[] args) throws IOException {
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLServerSocketChannel serverChannel = SSLServerSocketChannel.open();
        serverChannel.bind(null, 8443); // Bind to port 8443 with SSL
        serverChannel.configureBlocking(false);

        while (true) {
            SocketChannel clientChannel = serverChannel.accept();
            if (clientChannel != null) {
                SSLSocket clientSocket = (SSLSocket) clientChannel.socket();
                clientSocket.setNeedClientAuthentication(true); // Enable client authentication
                clientSocket.setPassword(PASSWORD);

                // Setup handshake
                byte[] seed = new byte[1];
                secureRandom.nextBytes(seed);
                clientSocket.setEnableAlpn(true);
                clientSocket.setAlpnProtocols(new String[]{"h2", "http/1.1"});
                clientSocket.setHighestProtocolVersion(SSLSocketFactory.HIGHEST_PROTOCOL);
                clientSocket.setNeedClientAuth(true);

                // Setup cipher suites for SSL/TLS
                clientSocket.setCipherSuites(new String[]{
                    "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384",
                    "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
                    "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256",
                    "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256",
                    "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256",
                    "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256"
                });

                // Setup key and certificate
                clientSocket.setEnabledCipherSuites(clientSocket.getCipherSuites());
                SSLCertificate certificate = new SSLCertificate("certificate.pem", "key.pem");
                clientSocket.setNeedClientCertIndication(true);
                clientSocket.setNeedSessionCache(true);
                clientSocket.setSessionCache(new SSLSessionCache(new FileInputStream("session_cache_file")));
                clientSocket.setUseClientMode(true);
                clientSocket.setCertificate(certificate);

                // Setup read/write buffer size
                clientSocket.setOption(StandardSocketOptions.SO_RCVBUF, 1024);
                clientSocket.setOption(StandardSocketOptions.SO_SNDBUF, 1024);

                // Handle the client connection
                new Handler(clientSocket).start();
            }
        }
    }
}