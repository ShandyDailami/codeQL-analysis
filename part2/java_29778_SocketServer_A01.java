import java.io.*;
import java.net.*;

public class java_29778_SocketServer_A01 {
    private static final String PASSWORD = "secure";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientPassword = reader.readLine();

            if (clientPassword.equals(PASSWORD)) {
                writer.writeBytes("Access granted.\n");
            } else {
                writer.writeBytes("Access denied.\n");
            }

            writer.flush();
            socket.close();
        }
    }
}