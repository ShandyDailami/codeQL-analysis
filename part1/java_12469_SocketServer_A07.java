import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_12469_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port: " + port);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                    try (InputStream in = socket.getInputStream();
                         OutputStream out = socket.getOutputStream()) {

                        byte[] buffer = new byte[1024];
                        int bytesRead = in.read(buffer);

                        if (bytesRead < 0) {
                            System.out.println("Client disconnected");
                            break;
                        }

                        String message = new String(buffer, 0, bytesRead);
                        System.out.println("Received: " + message);

                        String response = "Hello, client";

                        out.write(response.getBytes());
                        System.out.println("Sent: " + response);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}