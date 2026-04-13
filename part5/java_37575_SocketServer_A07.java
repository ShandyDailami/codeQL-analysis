import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37575_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                new Handler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler extends Thread {
    private final Socket client;

    public java_37575_SocketServer_A07(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Check for authentication failure
            if (authenticate()) {
                // Handle the client here
                // ...
            } else {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate() {
        // Implement your authentication logic here.
        // For the sake of example, we'll just return false.
        return false;
    }
}