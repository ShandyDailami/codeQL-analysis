import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09930_SocketServer_A01 {

    private final int port;
    private boolean running;
    private ServerSocket serverSocket;

    public java_09930_SocketServer_A01(int port) {
        this.port = port;
        this.running = false;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            running = true;
            System.out.println("Server started on port " + port);

            while(running) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted a new client from " + clientSocket.getRemoteSocketAddress());

                // Here, you can implement your security-sensitive operations related to Broken Access Control

                // For simplicity, we'll just close the connection after security-sensitive operations
                clientSocket.close();
           
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.running = false;
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(1234);
        server.start();
    }
}