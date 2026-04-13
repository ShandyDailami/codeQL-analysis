import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29258_SocketServer_A07 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected");

                // Send response to client
                String response = "Hello, client!\n";
                clientSocket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}