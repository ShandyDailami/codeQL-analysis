import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19462_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("IOException during server initialization: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_19462_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Handle the client's request here
            // This is just a placeholder and not a security-sensitive operation
            socket.getInputStream().read();
            socket.getOutputStream().write(1);
        } catch (IOException e) {
            System.out.println("IOException in ClientHandler: " + e.getMessage());
        }
    }
}