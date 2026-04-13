import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08574_SocketServer_A03 {
    private int port;
    private ServerSocket serverSocket;

    public java_08574_SocketServer_A03(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
        } catch (IOException e) {
            System.out.println("Cannot bind port " + port + ". Maybe a port is already in use.");
            System.exit(-1);
        }
    }

    public void listenForClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client communication here...

            } catch (IOException e) {
                System.out.println("Failed to accept client connection.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.listenForClients();
    }
}