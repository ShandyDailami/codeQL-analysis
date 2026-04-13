import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16639_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Security-sensitive operations
                // Here, we simulate a security-sensitive operation where the client sends a message
                // to the server. The server then responds with a username.
                // This is a very basic example and should not be used for real-world security
                // applications. It's also not practical to verify the username on the server side.
                // For a real-world application, you'd need to use a more secure method for verifying the identity of the client.

                socket.getInputStream().read();  // Read a byte from the socket
                socket.getOutputStream().write("Username: ".getBytes());  // Write the username
                socket.getOutputStream().flush();
                socket.getOutputStream().write(socket.getLocalSocketPort() + "\n".getBytes());  // Write the port the client connected to
                socket.getOutputStream().flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}