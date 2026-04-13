import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41758_SocketServer_A08 {
    private static final int PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here you can perform security-sensitive operations related to IntegrityFailure
                // For simplicity, we're just printing the message from the client
                String clientMessage = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
                System.out.println("Received message: " + clientMessage);

                // Assume the client wants to send a message back to the client
                String responseMessage = "IntegrityFailure resolved!";
                socket.getOutputStream().write(responseMessage.getBytes());
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}