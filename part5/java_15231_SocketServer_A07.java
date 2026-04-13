import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15231_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server is running on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            String clientInput = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
            System.out.println("Client input: " + clientInput);

            String response = "Authentication failed.";

            if (clientInput.equals(USERNAME + ":" + PASSWORD)) {
                response = "Authentication successful.";
            }

            socket.getOutputStream().write(response.getBytes());
            socket.getOutputStream().flush();

            socket.close();
        }
    }
}