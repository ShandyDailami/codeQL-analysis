import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13092_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the request
                new Handler(clientSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex);
        }
    }
}

class Handler extends Thread {
    private final Socket socket;

    public java_13092_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations related to A03_Injection
            // ...

            // Read from and write to the client
            byte[] buffer = new byte[1024];
            int length;
            while ((length = socket.getInputStream().read(buffer)) != -1) {
                socket.getOutputStream().write(buffer, 0, length);
            }

            // Close the socket connection
            socket.close();

        } catch (IOException ex) {
            System.out.println("Error handling client connection: " + ex);
        }
    }
}