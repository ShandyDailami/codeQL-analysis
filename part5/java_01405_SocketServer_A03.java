import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01405_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("A client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error creating server socket: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Handles a single client
    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_01405_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client's request here
            // This is a simplistic example, the actual code should be more complex and secure
            // It uses a simple input and output stream to read and write data
            try {
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead == -1) {
                    return;
                }

                String response = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + response);

                String sanitizedResponse = sanitizeInput(response);

                byte[] sanitizedBuffer = sanitizedResponse.getBytes();
                socket.getOutputStream().write(sanitizedBuffer);
                socket.getOutputStream().flush();

            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private String sanitizeInput(String input) {
            // Perform some simple input sanitization
            // This is a simplistic example, the actual code should be more complex and secure
            // It will replace any non-alphanumeric characters with a space, for example
            return input.replaceAll("[^a-zA-Z0-9]", " ");
        }
    }
}