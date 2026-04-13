import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19924_SocketServer_A08 {
    private int port;
    private ServerSocket serverSocket;

    public java_19924_SocketServer_A08(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Server could not bind to port " + port);
            System.exit(-1);
        }
    }

    public void start() {
        System.out.println("Server started at port " + port);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                handleClient(clientSocket);
            } catch (IOException e) {
                System.out.println("Client connection failed");
                System.exit(-1);
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        // Your implementation for handling client
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(5000);
        server.start();
    }
}