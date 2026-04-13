import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15126_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Perform security sensitive operations here
                // For example, code to read and write data
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);

                // Send response back to the client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}