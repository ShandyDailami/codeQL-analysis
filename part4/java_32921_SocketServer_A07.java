import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_32921_SocketServer_A07 {
    private static final String PASSWORD = "1234";
    private Map<String, PrintWriter> clients;
    private ServerSocket serverSocket;

    public java_32921_SocketServer_A07() throws IOException {
        serverSocket = new ServerSocket(1234);
        clients = new HashMap<>();
    }

    public void start() throws IOException {
        System.out.println("Server is running...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            clients.put(socket.getRemoteSocketAddress().toString(), out);
            out.println("Welcome to the server!");

            String clientPassword = socket.getInputStream().readUTF();
            if (!authenticate(clientPassword)) {
                out.println("Authentication failed.");
                continue;
            }

            out.println("Authentication successful.");
        }
    }

    private boolean authenticate(String password) {
        return password.equals(PASSWORD);
    }

    public static void main(String[] args) throws IOException {
        new SocketServer().start();
    }
}