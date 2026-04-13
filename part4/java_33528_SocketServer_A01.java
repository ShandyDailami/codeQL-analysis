import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33528_SocketServer_A01 {

    private static final int PORT = 4445;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                // Perform secure operations related to Broken Access Control A01_BrokenAccessControl
                // ...

                // Close the connection
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}