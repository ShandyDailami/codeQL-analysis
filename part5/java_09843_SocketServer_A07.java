import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09843_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform auth failure protection here
                // Example of a simple authentication
                String authCode = "1234";
                byte[] authCodeBytes = authCode.getBytes();

                if (socket.getInputStream().read(authCodeBytes) != authCodeBytes.length) {
                    System.out.println("Authentication failed");
                    socket.close();
                    continue;
                }

                // Handle the client
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle the client here
    }
}