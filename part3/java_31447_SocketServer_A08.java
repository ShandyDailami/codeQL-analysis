import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31447_SocketServer_A08 {
    private int port;

    public java_31447_SocketServer_A08(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Start your threads here
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}