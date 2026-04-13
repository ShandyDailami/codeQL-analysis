import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25296_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we're assuming the client sends a message to authenticate them.
            // You'd typically use a more secure method to handle this in a real-world scenario.
            String message = socket.getInputStream().readUTF();
            if ("authenticate".equals(message)) {
                // Authentication successful, continue the conversation
                socket.getOutputStream().writeUTF("Authentication successful");
                socket.getOutputStream().flush();
            } else {
                // Authentication failed, close the connection
                socket.close();
                System.out.println("Authentication failed");
            }
        }
    }
}