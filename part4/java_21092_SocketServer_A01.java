import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21092_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Handle the client connection in a new thread
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_21092_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read and handle incoming client message
            // This is a simple example and doesn't include any security-sensitive operations
            // You should replace this with your own logic
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Write response to client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}