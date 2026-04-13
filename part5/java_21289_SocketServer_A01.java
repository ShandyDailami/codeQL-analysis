import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21289_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Here you should handle the secure communication with the client
                // This is a placeholder for the task of handling secure communication
                new Handler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + PORT + ". " + e);
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_21289_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle secure communication here
        // This is a placeholder for the task of handling secure communication
    }
}