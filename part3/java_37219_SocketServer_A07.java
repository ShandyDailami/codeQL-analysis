import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_37219_SocketServer_A07 {
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", "password");
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Authentication
                String username = input.readUTF();
                String password = input.readUTF();
                if (validateUser(username, password)) {
                    output.writeUTF("Authentication successful");
                } else {
                    output.writeUTF("Authentication failed");
                    socket.close();
                    continue;
                }

                // Main communication
                while (true) {
                    String message = input.readUTF();
                    if (message.equals("exit")) {
                        break;
                    }
                    output.writeUTF("Received: " + message);
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean validateUser(String username, String password) {
        return userDatabase.get(username).equals(password);
    }
}