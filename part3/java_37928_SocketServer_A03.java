import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.util.logging.Logger;

public class java_37928_SocketServer_A03 {
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLSocketFactory();
            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT, 10000, InetAddress.getByName("localhost"));
            serverSocket.setEnabledCertificateEntryLoadBalancer(true);
        } catch (IOException e) {
            LOGGER.severe("Failed to create server socket: " + e.getMessage());
        }

        if (serverSocket != null) {
            SSLSocket clientSocket = null;
            try {
                clientSocket = (SSLSocket) serverSocket.accept();
                LOGGER.info("Accepted connection from: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                LOGGER.severe("Failed to accept client connection: " + e.getMessage());
            }
        }
    }
}