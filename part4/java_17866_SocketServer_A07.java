import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_17866_SocketServer_A07 {

    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());

    private boolean isStopped = false;

    private SSLServerSocket serverSocket = null;

    public void stop() {
        isStopped = true;
        try {
            serverSocket.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to close the server", e);
       
        }
    }

    public void start(int port) throws IOException {
        stop();
        serverSocket = (SSLServerSocket) new SSLServerSocket(port);
        LOGGER.info("Secure Socket Server Started on port " + port);
        while (!isStopped) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                // Handle accepted SSLSocket
                LOGGER.info("Accepted new client connection from: "
                        + sslSocket.getRemoteSocketAddress());
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Failed to accept client connection", ex);
                continue;
            }
            // Handle client connection
            // ...
        }
        LOGGER.info("Secure Socket Server Stopped.");
    }

    public static void main(String[] args) throws IOException {
        int port = 7000;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        SecureSocketServer server = new SecureSocketServer();
        server.start(port);
    }
}