import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05325_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Perform security-sensitive operations
                // For example, we're just echoing back the message to the client
                String message = new String(socket.getInputStream().readAllBytes(), "UTF-8");
                socket.getOutputStream().write(message.getBytes());
                socket.getOutputStream().flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}