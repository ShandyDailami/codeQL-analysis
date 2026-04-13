import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09700_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_09700_SocketServer_A07(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // read a message from the client
            // for simplicity, we'll use a static message
            byte[] buffer = "Hello, client!".getBytes();
            client.getOutputStream().write(buffer);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}