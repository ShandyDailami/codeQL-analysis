import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12490_SocketServer_A08 {
    private static final int SERVER_PORT = 4445;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_12490_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here, you can add your security-sensitive operations related to A08_IntegrityFailure
    }
}