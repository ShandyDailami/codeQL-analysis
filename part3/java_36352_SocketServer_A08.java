import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36352_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Create new thread for each client
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Create input and output streams
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read message from client
            byte[] buffer = new byte[1024];
            int bytes = input.read(buffer);
            if (bytes != -1) {
                String message = new String(buffer, 0, bytes);
                System.out.println("Received: " + message);

                // Send the message back to the client
                output.write(message.getBytes());
                output.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}