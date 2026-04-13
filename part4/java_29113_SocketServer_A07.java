import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29113_SocketServer_A07 {

    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform authentication here. This is a simple example where the client is required to provide a valid username.
                // In a real-world application, you would likely use a more secure method of authentication, such as a pre-shared key or a hash.
                String username = socket.getInputStream().readUTF();
                if ("validUsername".equals(username)) {
                    socket.getOutputStream().writeUTF("Authentication successful");
                } else {
                    socket.getOutputStream().writeUTF("Authentication failed");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}