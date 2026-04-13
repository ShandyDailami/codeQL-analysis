import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25913_SocketServer_A01 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started.");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected.");

                // Breaking access control
                String message = "Connection established, password required.";
                client.getOutputStream().write(message.getBytes());
                client.getOutputStream().flush();

                String response = new String(client.getInputStream().readNBytes(client.getInputStream().available()));
                if (!PASSWORD.equals(response.trim())) {
                    System.out.println("Wrong password, connection refused.");
                    client.close();
                } else {
                    System.out.println("Access granted.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}