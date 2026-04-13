import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12598_SocketServer_A07 {

    private static final int PORT = 6000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client connection
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_12598_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client connection and data here
        // You can use standard libraries like BufferedReader and PrintWriter
    }
}