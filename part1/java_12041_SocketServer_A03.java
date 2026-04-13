import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12041_SocketServer_A03 {

    private static final int DEFAULT_PORT = 12345;

    private int port;
    private ServerSocket serverSocket;

    public java_12041_SocketServer_A03() throws IOException {
        this(DEFAULT_PORT);
    }

    public java_12041_SocketServer_A03(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private void handleClient(Socket clientSocket) {
        // Handle client connection...
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer();
        server.start();
    }
}