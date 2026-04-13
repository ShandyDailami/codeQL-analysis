import java.net.ServerSocket;
import java.net.Socket;

public class java_32278_SocketServer_A08 {

    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port: " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                // Here we start the new thread for this client
                new ClientHandler(socket).start();
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_32278_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here we handle the client connection and data
        // For now, we'll just print out the received data
        try {
            while ((socket.getInputStream().read()) != -1) {
                System.out.println("Received data from client");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}