import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40552_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations here, e.g., check if the client is allowed to connect
                if (isClientAllowed(socket.getInetAddress().getHostAddress())) {
                    new ClientHandler(socket).start();
                } else {
                    System.out.println("Client is not allowed to connect: " + socket.getInetAddress().getHostAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isClientAllowed(String clientAddress) {
        // Implement the logic to check if a client is allowed to connect, e.g., from a database or configuration file
        // For simplicity, we just return true for all clients
        return true;
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_40552_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform operations with the client here
            // For example, read from and write to the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead != -1) {
                System.out.println("Received: " + new String(buffer, 0, bytesRead));
            }

            socket.getOutputStream().write("Hello, client!".getBytes());
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}