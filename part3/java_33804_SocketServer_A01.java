import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33804_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected");

                // Spawn a new thread for each client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to listen on port " + PORT);
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_33804_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // ...
    }
}