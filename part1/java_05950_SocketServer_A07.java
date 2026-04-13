import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05950_SocketServer_A07 {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Authentication
                String clientUsername = socket.getInputStream().readUTF();
                String clientPassword = socket.getInputStream().readUTF();

                if (clientUsername.equals(AUTHENTICATED_USER) && clientPassword.equals(AUTHENTICATED_PASSWORD)) {
                    System.out.println("Authenticated user " + clientUsername);
                    socket.getOutputStream().writeUTF("Authenticated");
                } else {
                    System.out.println("Failed to authenticate user " + clientUsername);
                    socket.getOutputStream().writeUTF("Failed to authenticate");
               
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}