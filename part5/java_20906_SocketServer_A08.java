import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20906_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security sensitive operation here (e.g. IntegrityFailure)

                // Create thread for handling client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_20906_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Handle client here
        // Perform security sensitive operations (e.g. IntegrityFailure)
    }
}