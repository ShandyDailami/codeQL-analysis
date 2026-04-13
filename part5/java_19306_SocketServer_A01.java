import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19306_SocketServer_A01 {
    private static final int PORT = 4445;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here you can implement the logic to handle the socket,
                // such as implementing a simple protocol, using SSL, or
                // handling security-sensitive operations like A01_BrokenAccessControl.
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}