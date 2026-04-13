import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_04973_SocketServer_A03 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());

    private SSLServerSocket sslServerSocket;
    private ServerSocket serverSocket;
    private boolean isStopped = false;

    public java_04973_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        sslServerSocket = (SSLServerSocket) sslServerSocket.newServerSocket(port);

        // Set up SSL server socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) sslServerSocket.getSocketFactory();
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

        sslServerSocket.setNeedClientAuth(true);
        sslServerSocket.setEnabledCipherSuites(new String[] { "SSL_RSA_WITH_AES_128_CBC_SHA256" });
        sslServerSocket.setEnabledProtocols(new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2" });
    }

    public void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!isStopped()) {
                        Socket clientSocket = sslServerSocket.accept();
                        handleClient(clientSocket);
                    }
                    sslServerSocket.close();
                    serverSocket.close();
                } catch (SocketException e) {
                    LOGGER.warning("Server Stopped due to SocketException: " + e);
                } catch (IOException e) {
                    LOGGER.warning("Server Stopped due to IOException: " + e);
                }
            }
        }).start();
    }

    private void handleClient(Socket clientSocket) {
        try {
            InetAddress clientAddress = clientSocket.getInetAddress();
            LOGGER.info("Client connected from " + clientAddress);

            // Here you can handle the client's request

            clientSocket.close();
        } catch (IOException e) {
            LOGGER.warning("Error handling client: " + e);
        }
    }

    public void stopServer() {
        isStopped = true;
        try {
            sslServerSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            LOGGER.warning("Error stopping server: " + e);
        }
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(8080);
            server.startServer();
        } catch (IOException e) {
            LOGGER.warning("Could not start server: " + e);
        }
    }
}