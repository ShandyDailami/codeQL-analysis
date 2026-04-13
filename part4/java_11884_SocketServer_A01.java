import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11884_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = server.accept();
                System.out.println("Client accepted!");
                handleRequest(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try {
            // handle request using socket
            // for example, read request from client, process it, send response back
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}