import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31369_SocketServer_A07 {
    private static final int PORT = 4000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT, 0, InetAddress.getByName("localhost"));
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Here you can implement your security-sensitive operations like authentication
            // For now, let's just accept the connection and ignore it
        }
    }
}