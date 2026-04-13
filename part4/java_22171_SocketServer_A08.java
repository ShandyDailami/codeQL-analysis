import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22171_SocketServer_A08 {

    private final int port;
    private final SSLServerSocket serverSocket;
    private final SSLContext sslContext;

    public java_22171_SocketServer_A08(int port) throws IOException {
        this.port = port;
        this.serverSocket = (SSLServerSocket) new ServerSocket(port);
        this.serverSocket.setNeedClientAuth(true);

        SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
        sslServerSocket.setNeedClientAuth(true);

        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("/truststore.jks"), "truststorepassword".toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(getClass().getResourceAsStream("/keystore.jks"), "keystorepassword".toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, "keystorepassword".toCharArray());

        SSLServerSocket sslSocket = (SSLServerSocket) sslServerSocket;
        sslSocket.setTrustManager(trustManagerFactory);
        sslSocket.setKeyManager(keyManagerFactory);

        this.sslContext = SSLContext.getInstance("TLS");
        this.sslContext.init(keyManagerFactory, trustManagerFactory, null);
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            SSLSocket sslSocket = (SSLSocket) sslContext.wrapSocket(clientSocket);
            HandshakeRequestHandler requestHandler = new HandshakeRequestHandler(sslSocket, true);
            SSLConnection sslConnection = new SSLConnection(sslSocket, requestHandler);
            sslConnection.startHandshake();
            // Process the SSLConnection here
        }
    }

    public static void main(String[] args) throws Exception {
        new SecureSocketServer(8080).start();
    }
}