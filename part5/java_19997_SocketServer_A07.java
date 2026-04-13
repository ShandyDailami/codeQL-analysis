import java.io.*;
import java.net.*;

public class java_19997_SocketServer_A07 {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String clientUsername = reader.readLine();
            String clientPassword = reader.readLine();

            if (authenticate(clientUsername, clientPassword)) {
                writer.write("Authentication successful!".getBytes());
            } else {
                writer.write("Authentication failed!".getBytes());
            }

            socket.close();
        }
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}