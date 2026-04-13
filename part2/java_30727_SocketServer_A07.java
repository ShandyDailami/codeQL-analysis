import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30727_SocketServer_A07 {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is running on " + SERVER_ADDRESS + ":" + SERVER_PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String clientUsername = reader.readLine();
                String clientPassword = reader.readLine();

                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    writer.println("Hello, client!");
                } else {
                    writer.println("Authentication failed!");
                }
            }
        }
    }
}