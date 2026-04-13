import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04705_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connection...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Handle client connection in separate thread
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_04705_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client connection and communication here
    }
}