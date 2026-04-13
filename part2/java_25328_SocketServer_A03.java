import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25328_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Start a new thread for each client
            new Thread(new SocketHandler(socket)).start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_25328_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations here
            // For example, check if the client's IP is allowed to connect
            String clientIP = socket.getRemoteSocketAddress().toString();
            if (isClientAllowed(clientIP)) {
                // Perform the main work of the socket server
                // Here, we're just echoing back the received message
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                if (bytesRead != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } else {
                System.out.println("Client IP " + clientIP + " is not allowed to connect");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement the necessary security-sensitive operations here
    private boolean isClientAllowed(String clientIP) {
        // This method should return true if the client IP is allowed, false otherwise
        // For the purpose of this example, we're just checking if the client's IP is localhost
        return clientIP.equals("localhost");
    }
}