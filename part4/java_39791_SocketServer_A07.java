import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39791_SocketServer_A07 {
    private static final String AUTH_SUCCESS = "Auth successful";
    private static final String AUTH_FAILURE = "Auth failed";
    private static final int PORT = 8080;
    private static ServerSocket server;

    private static String handleAuthentication(String username, String password) {
        // This is a placeholder for your actual authentication. 
        // Replace it with your own authentication logic.
        if (username.equals("admin") && password.equals("password")) {
            return AUTH_SUCCESS;
        } else {
            return AUTH_FAILURE;
        }
    }

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            // Assume that the client sends a username and password
            String username = client.getInputStream().readUTF();
            String password = client.getInputStream().readUTF();

            // Authenticate the client
            String response = handleAuthentication(username, password);

            // Send the response back to the client
            client.getOutputStream().writeUTF(response);
            client.getOutputStream().flush();
        }
    }
}