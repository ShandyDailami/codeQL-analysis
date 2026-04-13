import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11474_SocketServer_A03 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());

                // Handling the client in a separate thread
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket client;

    public java_11474_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // Reading the client's message
            while (true) {
                byte[] buffer = new byte[1024];
                int bytesRead = client.getInputStream().read(buffer);

                if (bytesRead == -1) {
                    client.close();
                    System.out.println("Client disconnected");
                    break;
                }

                // Process the message (e.g., print it)
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}