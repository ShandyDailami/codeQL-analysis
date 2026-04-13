import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05763_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444, 0, InetAddress.getByName("localhost"));
            System.out.println("Server started on port: " + server.getLocalPort() + " with IP: " + server.getLocalSocketAddress());

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

                // Here, you can start processing the socket connections here.
                // In a real-world application, you would want to handle multiple connections at once,
                // and handle each socket connection in a separate thread or different way to prevent blocking.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}