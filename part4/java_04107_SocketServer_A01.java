import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04107_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for a connection on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Only allow connections from localhost
                if (socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                    new SecureSocketServerHandler(socket).start();
                } else {
                    socket.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception occurred while running the server: " + e.getMessage());
        }
    }
}

class SecureSocketServerHandler extends Thread {
    private final Socket socket;

    public java_04107_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection in a separate thread
        // ...
    }
}