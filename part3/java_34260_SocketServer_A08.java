import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34260_SocketServer_A08 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle the socket connection in a separate thread
                new Handler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private Socket socket;

        public java_34260_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Receive data from the client and process it
            try (socket = new Socket(socket.getRemoteSocketAddress())) {
                // Read data from the socket
                byte[] buffer = new byte[1024];
                int bytes = socket.getInputStream().read(buffer);
                if (bytes != -1) {
                    // Process the received data
                    String data = new String(buffer, 0, bytes);
                    System.out.println("Received data: " + data);

                    // Send response to the client
                    String response = "Response: " + data;
                    socket.getOutputStream().write(response.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}