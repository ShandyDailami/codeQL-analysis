import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38084_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                new SecureClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class SecureClientHandler extends Thread {
    private Socket clientSocket;

    public java_38084_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations here (e.g., checking and validating user credentials)

            // Perform data exchange
            // You can use a buffered reader and writer for secure data exchange

        } catch (IOException e) {
            System.out.println("Client handler failed to handle client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}