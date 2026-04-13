import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33111_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Create a new thread for handling each client
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_33111_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read from the socket
            // ... (Read data, handle integrity failure etc)

            // Write back to the socket
            // ... (Write data, handle integrity failure etc)

            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}