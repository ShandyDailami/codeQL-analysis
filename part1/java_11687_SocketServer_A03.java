import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11687_SocketServer_A03 {
    private int port;

    public java_11687_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform operations related to the accepted socket here

                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while handling client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}