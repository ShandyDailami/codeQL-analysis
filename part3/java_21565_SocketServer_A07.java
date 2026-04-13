import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_21565_SocketServer_A07 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        final int port = 12345;

        try {
            ServerSocket serverSocket = null;
            if (System.getProperty("java.protocol.endorser") != null) {
                // For Java 9 and later, use SSLServerSocketFactory
                serverSocket = ((SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(port));
            } else {
                // For Java 8, use SSLServerSocket
                serverSocket = new SSLServerSocket(port);
           
            }
            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.log(Level.INFO, "Accepted connection from " + clientSocket.getRemoteSocketAddress());
                InetAddress remoteAddress = clientSocket.getInetAddress();
                logger.log(Level.INFO, "Remote IP address is " + remoteAddress.getHostAddress());
                // Process the client connection
                // For simplicity, we just echo back the message
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error accepting client connection", ex);
            System.exit(-1);
        }
    }
}