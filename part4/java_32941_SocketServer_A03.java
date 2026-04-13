import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32941_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Thread for handling each client
                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Here we can perform operations that are safe from injection attacks
            // E.g. reading data from the client, sending data back to the client, etc.
            // For example, reading the input stream
            // BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // String input = reader.readLine();
            // System.out.println("Received: " + input);

            // For example, writing a response to the client
            // PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // writer.println("Hello, client!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}