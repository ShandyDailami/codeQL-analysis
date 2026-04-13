import java.io.*;
import java.net.*;

public class java_15548_SocketServer_A08 {

    private static final int PORT = 8080;
    private static Socket socket;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Create a custom checksum for security-sensitive operations
                String checksum = createChecksum(message);

                // Send the checksum back to the client
                out.writeUTF(checksum);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createChecksum(String data) {
        byte[] bytes = data.getBytes();
        int checksum = 0;

        for (int i = 0; i < bytes.length; i++) {
            checksum += bytes[i];
        }

        return String.valueOf(checksum);
    }
}