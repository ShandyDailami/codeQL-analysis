import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_21635_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("127.0.0.1");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot get local address", e);
            System.exit(1);
        }

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8080, 1000, address);

            sslServerSocket.setNeedClientAuth(true);

            while (true) {
                Socket socket = sslServerSocket.accept();
                logger.info("Accepted connection from: " + socket.getRemoteSocketAddress());

                // Here you can handle the socket here, but in a realistic scenario,
                // you would probably want to wrap the socket in a thread and handle it there.

                socket.close();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create SSL Server Socket", e);
        }
    }
}