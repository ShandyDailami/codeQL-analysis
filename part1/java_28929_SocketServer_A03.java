import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28929_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_28929_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read request from client
            // ... (Assuming the client sends an HTTP request)

            // Send response back to client
            // ... (Assuming the server sends a HTTP response)

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}