import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01528_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected!");

                // Handle client communication here

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}