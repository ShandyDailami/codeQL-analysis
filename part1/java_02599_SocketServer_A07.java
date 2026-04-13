import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02599_SocketServer_A07 {
    private int port;

    public java_02599_SocketServer_A07(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Handle client connection...
            }
        } catch (IOException e) {
            System.out.println("Error during server initialization: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new VanillaSocketServer(8080).start();
    }
}