import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28008_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations related to A08_IntegrityFailure
                // ...

                // Start processing the request here
                // ...

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}