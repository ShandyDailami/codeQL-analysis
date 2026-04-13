import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16122_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client connection
                Thread clientHandler = new Thread(new SocketHandler(socket));
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection: " + e.getMessage());
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_16122_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can implement your authentication process here.
        // For simplicity, we'll just check if the socket address is valid
        if (socket.getRemoteSocketAddress().equals(socket.getLocalSocketAddress())) {
            System.out.println("Client authenticated successfully");
        } else {
            System.out.println("Failed to authenticate with client");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}