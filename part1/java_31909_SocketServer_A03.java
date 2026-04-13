import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31909_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to injection attacks
                // For example, use a simplified form of a command injection attack
                String command = socket.getInputStream().readUTF();
                if (command.equals("DROP TABLE")) {
                    System.out.println("Dropping table");
                    // Drop table is a security-sensitive operation, execute it here
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}