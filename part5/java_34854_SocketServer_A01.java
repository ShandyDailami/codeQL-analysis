import java.net.ServerSocket;
import java.net.Socket;

public class java_34854_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from: " + socket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations
                // ...

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}