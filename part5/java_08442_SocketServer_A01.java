import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08442_SocketServer_A01 {
    private static final int PORT = 6543;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                new Thread(() -> handleClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            socket.getInputStream().read(); // Read the first byte to get the username

            String username = readUsername(socket);
            String password = readPassword(socket);

            if (!isValid(username, password)) {
                System.out.println("Invalid username or password");
                return;
            }

            System.out.println("Client connected as " + username);

            // TODO: Send a response to the client

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readUsername(Socket socket) {
        return socket.getInputStream().readUTF();
    }

    private static String readPassword(Socket socket) {
        return socket.getInputStream().readUTF();
    }

    private static boolean isValid(String username, String password) {
        // TODO: Check if username and password match a known user in a database
        return true;
    }
}