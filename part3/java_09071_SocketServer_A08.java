import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09071_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            new Thread(() -> {
                // Start a new thread for each client connection
                handleRequest(socket);
                socket.close();
            }).start();
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            // Read the integrity check from the client
            byte[] bytes = new byte[10];
            socket.getInputStream().read(bytes);

            // Check the integrity check
            // For simplicity, we'll just compare the received data with a hardcoded value
            byte[] expected = "IntegrityCheck".getBytes();
            if (Arrays.equals(bytes, expected)) {
                System.out.println("Integrity check passed");

                // Send a response back to the client
                String response = "Integrity check passed";
                byte[] responseBytes = response.getBytes();
                socket.getOutputStream().write(responseBytes);
            } else {
                System.out.println("Integrity check failed");
                socket.getOutputStream().write("Integrity check failed".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}