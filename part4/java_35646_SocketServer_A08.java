import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35646_SocketServer_A08 {

    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is running on port " + SERVER_PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new Thread(() -> {
                    try {
                        // Send a welcome message back to the client
                        socket.getOutputStream().write("Welcome to the server\n".getBytes());

                        // Receive the client's message
                        byte[] buffer = new byte[1024];
                        int bytesRead = socket.getInputStream().read(buffer);
                        String message = new String(buffer, 0, bytesRead);
                        System.out.println("Received message: " + message);

                        // Send a response back to the client
                        socket.getOutputStream().write("Thank you for connecting\n".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}