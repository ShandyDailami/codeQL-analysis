import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04070_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);

        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected");

            // Send welcome message
            socket.getOutputStream().write("Welcome to the server!\n".getBytes());

            // Receive message from client
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);

            String message = new String(bytes);

            // Print received message
            System.out.println("Received message: " + message);

            socket.close();
        }
    }
}