import java.io.*;
import java.net.*;
import java.util.*;

public class java_25761_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(6666);

        System.out.println("Server is running...");

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientInput = in.readUTF();
            System.out.println("Client says: " + clientInput);

            String clientName = clientInput.split(" ")[0];
            String clientPassword = clientInput.split(" ")[1];

            if (authenticateClient(clientName, clientPassword)) {
                out.writeUTF("Authentication successful!");
            } else {
                out.writeUTF("Authentication failed!");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}