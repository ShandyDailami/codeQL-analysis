import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16964_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a new ServerSocket and bind it to port 9000
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Server started on port 9000");

            while (true) {
                // Wait for a client to connect
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle the client
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_16964_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client communication here
    }
}