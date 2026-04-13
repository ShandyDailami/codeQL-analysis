import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32349_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while setting up the server: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_32349_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the socket connection here
        // For now, just print the socket address
        System.out.println("Handling client at " + socket.getRemoteSocketAddress());

        try {
            // Close the socket here
            socket.close();
        } catch (IOException e) {
            System.out.println("Error occurred while handling the client: " + e.getMessage());
        }
    }
}