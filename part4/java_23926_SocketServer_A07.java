import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23926_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Implement Basic Authentication
                String username = socket.getInputStream().readUTF();
                String password = socket.getInputStream().readUTF();

                if ("user".equals(username) && "password".equals(password)) {
                    socket.getOutputStream().writeUTF("Authenticated");
                } else {
                    socket.getOutputStream().writeUTF("Failed to authenticate");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}