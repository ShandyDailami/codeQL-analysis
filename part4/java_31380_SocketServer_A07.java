import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31380_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Here we're implementing a simple authentication mechanism.
                // For the sake of simplicity, we'll assume that the username is correct and the password is a simple "Hello".
                // In a real-world scenario, you'd want to use a more secure method for authentication.
                String username = socket.getInputStream().readUTF();
                String password = socket.getInputStream().readUTF();

                if ("Hello".equals(password)) {
                    System.out.println("Authentication successful for user: " + username);

                    // Here we're just sending a simple response back to the client.
                    // In a real-world scenario, you'd want to send a more complex response.
                    socket.getOutputStream().writeUTF("Hello, " + username + "!");
                } else {
                    System.out.println("Authentication failed for user: " + username);
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}