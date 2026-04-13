import java.io.*;
import java.net.*;
import java.util.*;

public class java_14630_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String username = in.readUTF();
                String password = in.readUTF();

                if (authenticate(username, password)) {
                    out.writeUTF("Authentication successful");
                    out.flush();
                } else {
                    out.writeUTF("Authentication failed");
                    out.flush();
                    socket.close();
                    continue;
                }

                out.writeUTF("Thank you for connecting");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}