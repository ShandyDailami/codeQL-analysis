import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33505_SocketServer_A08 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket socket;

        public java_33505_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Handle client communication here
                // For example, verify the client's integrity
                // This is a very basic example and may not be enough for real-world applications
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);

                if (message.equals("A08_IntegrityFailure")) {
                    socket.getOutputStream().write("Successfully verified client's integrity".getBytes());
                } else {
                    socket.getOutputStream().write("Failed to verify client's integrity".getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}