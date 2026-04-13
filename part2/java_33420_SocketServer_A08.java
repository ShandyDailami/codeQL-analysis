import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class java_33420_SocketServer_A08 {

    private static final boolean SSL = true;
    private static final int PORT = 8080;

    public static void main(String[] args) {
        if (SSL) {
            startSSLServer();
        } else {
            startServer();
        }
    }

    private static void startSSLServer() {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT)) {
            while (true) {
                try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept()) {
                    processRequest(sslSocket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(PORT));
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    processRequest(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processRequest(Socket socket) throws IOException {
        // Handle request...
        socket.close();
    }
}