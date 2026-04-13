import java.net.ServerSocket;
import java.net.Socket;

public class java_34118_SocketServer_A03 {

    private int port;

    public java_34118_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here

                // Continue processing client

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        SecureSocketServer server = new SecureSocketServer(port);
        server.start();
    }
}