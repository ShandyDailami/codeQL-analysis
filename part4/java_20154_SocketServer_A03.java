import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20154_SocketServer_A03 {
    private static final int PORT = 8080;
    private static final int HTTPS_PORT = 8443;

    public static void main(String[] args) {
        startServer(PORT);
        startServer(HTTPS_PORT);
    }

    private static void startServer(int port) {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket socket = server.accept();
                InetAddress clientAddress = socket.getInetAddress();
                System.out.println("Client connected from " + clientAddress.getHostAddress());

                // Perform security-sensitive operations related to A03_Injection
                // Here we are just printing the message. In a real-world application,
                // this could involve e.g. sending back a response to the client
                System.out.println("Message from client: " + socket.getInputStream().readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}