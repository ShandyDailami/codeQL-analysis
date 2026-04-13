import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11596_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client request
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.err.println("Error while handling client request: " + ex.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_11596_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform authentication here using a secure authentication library or API
            // For simplicity, let's just check if the client's IP address is in a whitelist
            String clientIP = socket.getInetAddress().getHostAddress();
            if (!isWhitelisted(clientIP)) {
                System.out.println("Authentication failed for client " + clientIP);
                socket.close();
                return;
            }

            // Handle the client request
            // ...

        } catch (IOException ex) {
            System.err.println("Error while handling client request: " + ex.getMessage());
        }
    }

    private boolean isWhitelisted(String ip) {
        // Implement your own logic to check if a client IP is in the whitelist
        // This could be in a file, database, or some other storage
        // For simplicity, let's just check for a hardcoded list of IP addresses
        String[] whitelist = {"192.168.1.1", "127.0.0.1", "10.0.0.1"};
        for (String addr : whitelist) {
            if (addr.equals(ip)) {
                return true;
            }
        }
        return false;
    }
}