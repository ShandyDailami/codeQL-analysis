import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05393_SocketServer_A03 {
    private static final String VALID_USERNAME = "admin";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);

        while (true) {
            Socket socket = server.accept();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String username = reader.readLine();

                if (username.equals(VALID_USERNAME)) {
                    writer.println("Welcome back, " + username + "!");
                } else {
                    writer.println("403 Forbidden");
                }
            }
        }
    }
}