import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10122_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Accepted new client at " + socket.getRemoteSocketAddress());

                    OutputStream out = socket.getOutputStream();
                    String message = "Authenticated successfully\n";
                    out.write(message.getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}