import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03286_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            // Create a ServerSocket that listens on the PORT number
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Accept a new client
            Socket client = server.accept();
            System.out.println("Client connected");

            // Create a new thread to handle communication with the client
            Thread thread = new Thread(new ClientHandler(client));
            thread.start();

        } catch (IOException e) {
            System.out.println("Failed to connect to the port " + PORT);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_03286_SocketServer_A01(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // Here you can handle the communication with the client
        // For example, you can read from and write to the client
    }
}