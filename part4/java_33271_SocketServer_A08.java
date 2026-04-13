import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_33271_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SecureServer.class.getName());

    private static final int SERVER_PORT = 8080;

    private static byte[] clientHello = "Hello, Client!".getBytes();
    private static byte[] serverHello = "Hello, Server!".getBytes();

    public static void main(String[] args) {
        runServer();
    }

    public static void runServer() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(SERVER_PORT)) {
            serverSocket.setNeedClientAuth(true);
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            clientSocket.setNeedClientAuth(true);

            logger.log(Level.INFO, "Client authenticated successfully.");

            clientSocket.getInputStream().read(clientHello);
            clientSocket.getOutputStream().write(serverHello);
            clientSocket.getOutputStream().flush();

            byte[] resp = new byte[clientSocket.getInputStream().available()];
            clientSocket.getInputStream().read(resp);

            logger.log(Level.INFO, "Server's response: {0}", new String(resp));

            clientSocket.close();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}