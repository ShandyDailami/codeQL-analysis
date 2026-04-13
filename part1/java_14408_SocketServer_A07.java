import java.io.*;
import java.net.*;
import java.util.*;

public class java_14408_SocketServer_A07 {

    private static final String AUTH_USER = "admin";
    private static final String AUTH_PASS = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();
            System.out.println("Received from client: " + clientMessage);

            if (authenticateClient(in, out)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
            }

            socket.close();
        }
    }

    private static boolean authenticateClient(DataInputStream in, DataOutputStream out) throws IOException {
        String clientInput = in.readUTF();
        String[] credentials = clientInput.split(" ");

        if (credentials.length != 2) {
            out.writeUTF("Invalid input format. Expected username and password, but got " + clientInput);
            return false;
        }

        String clientUsername = credentials[0];
        String clientPassword = credentials[1];

        if (!AUTH_USER.equals(clientUsername) || !AUTH_PASS.equals(clientPassword)) {
            out.writeUTF("Invalid username or password");
            return false;
        }

        out.writeUTF("Authentication successful");
        return true;
    }
}