import java.io.*;
import java.net.*;
import java.util.Arrays;

public class java_24261_SocketServer_A07 {
    private static String ADMIN_USERNAME = "admin";
    private static String ADMIN_PASSWORD = "admin";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started, waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client accepted");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authentication
            String clientUsername = in.readUTF();
            String clientPassword = in.readUTF();

            if (!authenticate(clientUsername, clientPassword)) {
                out.writeUTF("Authentication failed");
                out.flush();
                socket.close();
                return;
            }

            // Main communication
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);
                out.writeUTF("Message received");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return Arrays.equals(username.getBytes(), ADMIN_USERNAME.getBytes()) &&
                Arrays.equals(password.getBytes(), ADMIN_PASSWORD.getBytes());
    }
}