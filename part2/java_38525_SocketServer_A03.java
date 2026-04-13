import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.Certificate;

public class java_38525_SocketServer_A03 {
    private final SSLServerSocket serverSocket;

    public java_38525_SocketServer_A03(int port, String keyStoreFile, String keyStorePassword, String certificateAlias) throws Exception {
        SSLServerSocket socket = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(getClass().getResourceAsStream(keyStoreFile), keyStorePassword.toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(getClass().getResourceAsStream("/truststore.jks"), keyStorePassword.toCharArray());

            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            sslServerSocketFactory.setKeyStore(keyStore);
            sslServerSocketFactory.setTrustStore(trustStore);

            socket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
            socket.setNeedClientAuthentication(true);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        serverSocket = (SSLServerSocket) socket;
    }

    public void startServer(int port) throws Exception {
        serverSocket.bind(port);

        while (true) {
            SSLSocket client = (SSLSocket) serverSocket.accept();
            client.startHandshake();

            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();

            // Send a response to the client
            output.write("Hello, client!".getBytes());
            output.close();
        }
    }

    public static void main(String[] args) throws Exception {
        SecureSocketServer server = new SecureSocketServer(4444, "server.jks", "password", "server");
        server.startServer(4444);
    }
}