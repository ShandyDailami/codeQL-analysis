import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_13603_SocketServer_A08 {

    private static final String KEYSTORE_LOCATION = "src/main/resources/mykeystore";
    private static final String KEYSTORE_PASSWORD = "mypassword";
    private static final String TRUSTSTORE_LOCATION = "src/main/resources/mytruststore";
    private static final String TRUSTSTORE_PASSWORD = "mypassword";

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = createServerSocket(8080);
            SSLServerSocketFactory sslServerSocketFactory = createSSLServerSocketFactory(serverSocket, KEYSTORE_LOCATION, TRUSTSTORE_LOCATION, KEYSTORE_PASSWORD, TRUSTSTORE_PASSWORD);
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket();
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();
                handleRequest(inputStream, outputStream);
                sslSocket.close();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static SSLServerSocketFactory createSSLServerSocketFactory(ServerSocket serverSocket, String keystoreLocation, String truststoreLocation, String keystorePassword, String truststorePassword) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keystoreLocation), keystorePassword.toCharArray());
            trustStore(keyStore, truststoreLocation, truststorePassword);
            sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory = new SSLServerSocketFactory(keyStore, trustStore, new SSLServerSocketFactory(new SSLServerSocketFactoryImpl()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslServerSocketFactory;
    }

    private static void trustStore(KeyStore keyStore, String truststoreLocation, String truststorePassword) throws Exception {
        TrustStore trustStore = new KeyStoreTrustStore(keyStore, truststoreLocation, truststorePassword);
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        sslServerSocketFactory = new SSLServerSocketFactory(sslServerSocketFactory, trustStore, new SSLServerSocketFactoryImpl());
    }

    private static void handleRequest(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int bytesRead = inputStream.read(bytes);
        if (bytesRead == -1) {
            return;
        }
        String message = new String(bytes, 0, bytesRead);
        System.out.println("Received: " + message);
        outputStream.write(bytes);
        outputStream.flush();
    }

    private static ServerSocket createServerSocket(int port) throws IOException {
        ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();
        ServerSocket serverSocket = serverSocketFactory.createServerSocket(port);
        serverSocket.setReuseAddress(true);
        return serverSocket;
    }
}