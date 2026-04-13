import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21614_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error listening for connections: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_21614_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new thread for each client
            new EchoServer(socket).start();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}

class EchoServer extends Thread {
    private Socket socket;

    public java_21614_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new buffer for each client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);

            if (bytesRead < 0) {
                System.out.println("Client disconnected");
            } else {
                // Send the received data back to the client
                socket.getOutputStream().write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}