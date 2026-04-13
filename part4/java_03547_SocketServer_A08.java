import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03547_SocketServer_A08 {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public java_03547_SocketServer_A08(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            System.out.println("Waiting for client...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");
        } catch (IOException e) {
            System.out.println("Failed to setup socket server.");
            e.printStackTrace();
            return;
        }
    }

    public void start() {
        new Handler(clientSocket).start();
    }

    public static void main(String[] args) {
        new SocketServer(8080);
    }
}