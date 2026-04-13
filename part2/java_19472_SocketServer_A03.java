import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19472_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_19472_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // TODO: Implement client-specific logic
    }
}