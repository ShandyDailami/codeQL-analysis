import java.io.*;
import java.net.*;

public class java_16086_SocketServer_A07 {
    private static final String AUTH_FAILURE = "A07_AuthFailure";
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();

            // handle authentication failure
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String request = reader.readLine();
                if (request.contains(AUTH_FAILURE)) {
                    OutputStream writer = socket.getOutputStream();
                    writer.write("Authentication failed, please try again.\n".getBytes());
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}