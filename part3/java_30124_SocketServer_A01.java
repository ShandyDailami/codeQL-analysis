import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30124_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here is where we implement the security-sensitive operations
                // This is just a placeholder, replace with actual implementation
                // Example: Checking if the client is allowed to connect
                if (socket.getRemoteSocketAddress().equals(serverSocket.getLocalSocketAddress())) {
                    System.out.println("Client is not allowed to connect.");
                    socket.close();
                } else {
                    // If the client is allowed, then we can safely start a new thread to handle the client
                    new ClientHandler(socket).start();
                }
           
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_30124_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here is where we implement the client handling logic, e.g., reading data, sending data, etc.
        // This is just a placeholder, replace with actual implementation
    }
}