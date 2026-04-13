import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41028_SocketServer_A01 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // TODO: Add code to handle secure communication,
                //       e.g. using SSL/TLS for secure communication,
                //       user authentication, etc.
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + PORT);
            e.printStackTrace();
        }
    }
}