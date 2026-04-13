import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

public class java_38460_SocketServer_A07 {
    private final int port;
    private final String password;

    public java_38460_SocketServer_A07(int port, String password) {
        this.port = port;
        this.password = password;
    }

    public void start() throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            System.out.println("Server started on port: " + port);

            SSLContext sslContext = createSSLContext(serverSocket);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                SSLSocket sslSocket = (SSLSocket) sslContext.getSocket(clientSocket);
                try (InputStream inputStream = sslSocket.getInputStream();
                     OutputStream outputStream = sslSocket.getOutputStream()) {
                    String clientPassword = readPassword(inputStream);
                    if (clientPassword.equals(password)) {
                        System.out.println("Authentication successful");
                        // Send a response if password is correct
                        writeResponse(outputStream, "Authenticated");
                    } else {
                        System.out.println("Authentication failed");
                        // Send a response if password is incorrect
                        writeResponse(outputStream, "Failed");
                    }
                }
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static SSLContext createSSLContext(ServerSocket serverSocket) throws IOException {
        String keyStoreType = "JKS";
        String keyStorePath = "keystore.jks";
        String keyStorePassword = "password";

        // Load the keystore and Truststore
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(getClass().getResourceAsStream(keyStorePath), keyStorePassword.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, keyStorePassword.toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory, trustManagerFactory, null);

        return sslContext;
    }

    private static String readPassword(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        return new String(bytes, 0, length);
    }

    private static void writeResponse(OutputStream outputStream, String message) throws IOException {
        outputStream.write(message.getBytes());
        outputStream.flush();
    }

    public static void main(String[] args) throws IOException {
        int port = 8888;
        String password = "password";
        SecureSocketServer server = new SecureSocketServer(port, password);
        server.start();
    }
}