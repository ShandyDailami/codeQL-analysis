import java.net.ServerSocket;
import java.net.Socket;

public class java_02220_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_02220_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            socket.getInputStream();
            socket.getOutputStream();

            // TODO: Add authentication and check if client is authorized
            // ...

            // TODO: Handle client messages
            // ...

            socket.close();
        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}