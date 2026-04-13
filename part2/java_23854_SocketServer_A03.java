import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23854_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("A client connected");

                // Sending a message to the client
                clientSocket.getOutputStream().write("Hello, client!\n".getBytes());

                // Receiving a message from the client
                byte[] bytes = new byte[1024];
                clientSocket.getInputStream().read(bytes);
                String message = new String(bytes);
                System.out.println("Received: " + message);
           
                // Here, the data is insecure, as it's directly printed to the client.
                // In a real-world application, it's safer to validate and sanitize the data.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}