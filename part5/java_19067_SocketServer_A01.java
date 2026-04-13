import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_19067_SocketServer_A01 {
    private static final String PASSWORD = "securepassword"; // Change this to a password you want

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server is running and waiting for connections on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Authenticate the client
                String clientPassword = socket.getInputStream().readUTF();
                if (!PASSWORD.equals(clientPassword)) {
                    System.out.println("Authentication failed");
                    socket.close();
                    continue;
                }

                // Process the request
                String request = socket.getInputStream().readUTF();
                System.out.println("Received request: " + request);
                String response = "Server response for " + request;
                socket.getOutputStream().writeUTF(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}