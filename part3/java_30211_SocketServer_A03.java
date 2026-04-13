import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30211_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());

            // You might want to use a separate thread for each client
            new HandleClient(socket).start();
        }
    }

    static class HandleClient extends Thread {
        private Socket socket;
        public java_30211_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // In a real application, you would probably want to use a different
                // protocol to handle the data, such as a custom class that you could
                // serialize and deserialize, and handle the connection in a different
                // thread. This is just a simple example.

                // Get input and output streams from the socket
                java.io.InputStream input = this.socket.getInputStream();
                java.io.OutputStream output = this.socket.getOutputStream();

                // Read the message from the client
                byte[] bytes = new byte[1024];
                int length = input.read(bytes);
                if (length < 0) {
                    System.out.println("Disconnected");
                    return;
                }

                String message = new String(bytes, 0, length);

                // We could potentially sanitize the input to prevent injection attacks.
                // For simplicity, we just echo the message back.
                // In a real application, you would likely want to replace this with
                // a secure way to send the message.
                String response = message;

                // Send the response back to the client
                output.write(response.getBytes());
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}