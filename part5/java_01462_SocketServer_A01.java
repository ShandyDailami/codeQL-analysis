import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01462_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // Here, we are just echoing back the message to the client
                handleClient(socket);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
       
        } finally {
            System.out.println("Server stopped.");
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Accept input stream from the client
            java.io.InputStream input = socket.getInputStream();

            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);

            // Echo the message back to the client
            java.io.OutputStream output = socket.getOutputStream();
            output.write(message.getBytes());
            output.flush();

        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}