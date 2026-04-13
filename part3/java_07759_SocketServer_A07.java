import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07759_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server is listening on port 8189");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected");

                // Read the username and password from the client
                socketReader(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void socketReader(Socket socket) {
        try {
            // Read the username and password from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String username = reader.readLine();
            String password = reader.readLine();

            if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
                // Authentication failed, close the connection
                socket.close();
                System.out.println("Authentication failed");
                return;
            }

            System.out.println("Authentication succeeded");

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}