import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32037_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String clientInfo = input.readUTF();
            System.out.println("Client Info: " + clientInfo);

            String[] credentials = clientInfo.split(":");
            String username = credentials[0];
            String password = credentials[1];

            if (isValidUser(username, password)) {
                output.writeUTF("Authentication Successful");
            } else {
                output.writeUTF("Authentication Failed");
            }

            client.close();
        }
    }

    private static boolean isValidUser(String username, String password) {
        // In real application, this method would query the database
        // for the username and password and compare them.
        // For the sake of simplicity, we'll just return true or false.
        return username.equals("admin") && password.equals("password");
    }
}