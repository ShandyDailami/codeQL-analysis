import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20023_SocketServer_A01 {

    private static final String BLOCKED_IP = "192.168.1.1"; // Blocked IP
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                InetAddress clientAddress = socket.getInetAddress();

                System.out.println("Accepted connection from " + clientAddress.getHostAddress());

                if (clientAddress.getHostAddress().equals(BLOCKED_IP)) {
                    System.out.println("Connection from blocked IP is denied.");
                    socket.close();
                } else {
                    System.out.println("Connection from unblocked IP is accepted.");
                    // Perform connection operations here
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}