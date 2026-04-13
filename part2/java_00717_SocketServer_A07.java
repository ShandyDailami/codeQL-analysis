import java.io.*;
import java.net.*;
import java.util.*;

public class java_00717_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Perform authentication
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            String username = input.readUTF();
            String password = input.readUTF();
            if (isValid(username, password)) {
                output.writeUTF("Success");
            } else {
                output.writeUTF("Failure");
            }

            socket.close();
        }
    }

    private static boolean isValid(String username, String password) {
        // Simple authentication for now. This is not secure. In real world applications,
        // passwords should be hashed and salted for security.
        return username.equals("admin") && password.equals("password");
    }
}