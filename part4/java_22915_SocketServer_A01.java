import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22915_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client connection
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_22915_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // TODO: Handle client connection and communication here
            // For now, we will just print a message and close the connection
            System.out.println("Handling client connection...");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}