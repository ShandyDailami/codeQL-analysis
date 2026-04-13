import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_04154_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";
    private Map<String, String> users = new HashMap<>();

    public java_04154_SocketServer_A07() {
        users.put(USERNAME, PASSWORD);
    }

    public void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Connected to the server");

            String clientMsg = socket.getInputStream().readUTF();
            String username = clientMsg.split(" ")[0];
            String password = clientMsg.split(" ")[1];

            if (authenticate(username, password)) {
                out.println("Authentication successful");
            } else {
                out.println("Authentication failed");
            }

            socket.close();
        }
    }

    private boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer().startServer(5000);
    }
}