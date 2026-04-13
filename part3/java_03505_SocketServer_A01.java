import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03505_SocketServer_A01 {

    private int port;
    private ServerSocket server;

    public java_03505_SocketServer_A01(int port) {
        this.port = port;
        try {
            this.server = new ServerSocket(port, 0, InetAddress.getByName("localhost"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        System.out.println("Starting server on port " + port);
        try {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                // Handling the client here
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket socket) {
        // TODO: Implement client handling
    }

    public void closeServer() {
        try {
            if (server != null) {
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}