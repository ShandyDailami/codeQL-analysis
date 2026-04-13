import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_28040_SocketServer_A08 {

    private static final boolean SSL = true;
    private static final int PORT = 8443;

    public static void main(String[] args) throws IOException {
        if (SSL) {
            startSSLServer(PORT);
        } else {
            startServer(PORT);
        }
    }

    private static void startSSLServer(int port) throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSL) new SSLServerSocket(port);
            System.out.println("Starting SSL Server on port " + port);
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                // handle client connection
            }
        } finally {
            serverSocket.close();
        }
    }

    private static void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Starting Server on port " + port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
            // handle client connection
        }
    }
}