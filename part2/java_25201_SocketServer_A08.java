import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25201_SocketServer_A08 {
    private int port;

    public java_25201_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Starting server on port " + port);
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket client = server.accept();
                System.out.println("Connected to " + client.getRemoteSocketAddress());

                // Handle the client connection here
                // For simplicity, just keep the connection open
                new Handler(client).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + port);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer(1234).start();
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_25201_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read from the socket
            // For simplicity, just keep the read here
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);
            System.out.println("Received: " + message);

            // Send a response
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}