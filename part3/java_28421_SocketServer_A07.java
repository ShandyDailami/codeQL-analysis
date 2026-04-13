import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28421_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                // Create new threads for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_28421_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement authentication logic
        // This is a simple example, in real application you'll need to use a secure method
        // for authentication such as SSL/TLS or JWT.
        // For now, let's just check if the socket can be connected
        try {
            socket.connect(new java.net.URI("socksproxy://example.com:1080"));
            System.out.println("Client connected");
        } catch (Exception e) {
            System.out.println("Failed to connect to client");
        }
    }
}