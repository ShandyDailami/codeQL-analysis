import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class java_36199_SocketServer_A07 {

    private int port;
    private ServerSocket serverSocket;

    public java_36199_SocketServer_A07(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    private void handleClient(Socket clientSocket) {
        // Implement your authentication mechanism here
        // If authentication fails, close the socket connection
        if (!authenticate(clientSocket)) {
            closeSocket(clientSocket);
            return;
        }
        // Handle the client here
    }

    private boolean authenticate(Socket socket) {
        // Implement your authentication logic here
        // Return true if authentication succeeds, false otherwise
        return false;
    }

    private void closeSocket(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(4444);
    }
}