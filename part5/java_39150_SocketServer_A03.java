import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39150_SocketServer_A03 {
    private static final String SERVER_STATUS = "Server running and waiting for connections...\n";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(65000)) {
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected!");

                // Create a new thread for each client
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port 65000.");
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_39150_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Authenticate client
            String clientInfo = clientSocket.getInetAddress() + ":" + clientSocket.getPort();
            if ("Client1".equals(clientInfo) || "Client2".equals(clientInfo)) {
                System.out.println("Authenticating client: " + clientInfo);
                clientSocket.close();
                return;
            }

            // Connection is secure
            System.out.println("Secure connection from: " + clientInfo);
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error while handling client " + clientInfo);
            e.printStackTrace();
        }
    }
}