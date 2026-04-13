import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40322_SocketServer_A07 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Handle the client connection here
                // For example, you can use a thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // A simple handler for a client connection
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_40322_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client communication here
            // For example, you can read data from the client and send it back
            try {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received: " + message);

                // Send a response back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}