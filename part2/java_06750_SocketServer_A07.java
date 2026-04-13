import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06750_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here you can add your message handling code
                // For now, we just echo back the message
                String message = "Hello, client!\n";
                socket.getOutputStream().write(message.getBytes());
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}