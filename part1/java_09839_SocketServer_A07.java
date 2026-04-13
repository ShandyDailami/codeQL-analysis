import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09839_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication
                // This is just a placeholder, in a real application, you should use
                // secure methods and implement authentication protocols.
                if (authenticate(socket)) {
                    handle(socket);
                } else {
                    System.out.println("Authentication failed. Closing connection.");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implementation of authentication
        // This is just a placeholder, in a real application, you should use
        // secure methods and implement authentication protocols.
        return true;
    }

    private static void handle(Socket socket) {
        // Handle incoming data
        // This is just a placeholder, in a real application, you should use
        // secure methods and implement handling protocols.
        try {
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            System.out.println("Received: " + new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}