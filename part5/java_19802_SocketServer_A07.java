import java.io.*;
import java.net.*;

public class java_19802_SocketServer_A07 {
    private static final String[] ALLOWED_CLIENTS = {"John", "Alice"};
    private static final String SERVER_SOCKET = "localhost";
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientName = input.readUTF();

            if (isClientAllowed(clientName)) {
                output.writeUTF("Authentication successful for " + clientName);
            } else {
                output.writeUTF("Authentication failed for " + clientName);
            }

            socket.close();
        }
    }

    private static boolean isClientAllowed(String clientName) {
        for (String allowedClient : ALLOWED_CLIENTS) {
            if (allowedClient.equals(clientName)) {
                return true;
            }
        }
        return false;
    }
}