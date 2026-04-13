import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29975_SocketServer_A03 {

    private int port;
    private ServerSocket serverSocket;

    public java_29975_SocketServer_A03(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        // Handle client connection and communication here
    }

    public static void main(String[] args) {
        SecureSocketServer server = new SecureSocketServer(5000);
        server.startServer();
    }
}