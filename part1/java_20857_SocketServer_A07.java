import java.net.ServerSocket;
import java.net.Socket;

public class java_20857_SocketServer_A07 {
    private int port;

    public java_20857_SocketServer_A07(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here, e.g., authentication.
                // For simplicity, we'll just print a message and close the connection.
                System.out.println("Received message: " + socket.getInputStream().read());
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        new LegacySocketServer(port).startServer();
    }
}