import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_07973_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            int port = 8888;
            ServerSocket serverSocket = (ServerSocket) sslServerSocketFactory.createServerSocket(port);
            serverSocket.setReuseAddress(true);
            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocket;
            sslServerSocket.setNeedClient(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                InetAddress clientAddress = socket.getInetAddress();
                logger.log(Level.INFO, "Accepted connection from " + clientAddress.toString());

                // Perform security-sensitive operations here...

                // For example, we'll write a simple message back to the client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Exception in accepting client connection", ex);
        }
    }
}