import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36598_SocketServer_A01 {
    private int port;

    public java_36598_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we use a simple check for a null socket. In a real-world scenario, you'd want to use a more robust mechanism for checking and sanitizing input.
            if (socket == null) {
                System.out.println("Null socket, closing connection");
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.start();
    }
}