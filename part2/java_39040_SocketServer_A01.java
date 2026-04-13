import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39040_SocketServer_A01 {

    // Define a port to listen on
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Create a ServerSocket
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is running on port " + PORT);

        while (true) {
            // Accept a client connection
            Socket client = server.accept();

            // Handle the client connection in a new thread
            new ClientHandler(client).start();
        }
    }

    // A handler for a client connection
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_39040_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Code to handle the client connection...
            // This is a placeholder, you'll need to implement the actual handling
            try {
                // Read the client's message
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead < 0) {
                    System.out.println("Client disconnected");
                    socket.close();
                } else {
                    // Simulate a security-sensitive operation related to A01_BrokenAccessControl
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + message);

                    // Respond with a message
                    String response = "You said: " + message + "\n";
                    socket.getOutputStream().write(response.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}