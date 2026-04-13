import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25654_SocketServer_A01 {
    private static final int PORT = 4445;
    private ServerSocket serverSocket;

    public java_25654_SocketServer_A01() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
        } catch (IOException e) {
            System.out.println("Error initializing server");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void listenForClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here

                // For now, just close the connection
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error handling client");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().listenForClients();
    }
}