import java.net.ServerSocket;
import java.net.Socket;

public class java_17983_SocketServer_A01 {
    private int port;

    public java_17983_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                // Perform security-sensitive operations here
                // ...
           
                socket.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}