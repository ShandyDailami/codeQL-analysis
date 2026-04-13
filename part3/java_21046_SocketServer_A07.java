import java.io.*;
import java.net.*;

public class java_21046_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Perform authentication
            if (authenticate(socket)) {
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                String response = "Hello, client!";
                output.writeUTF(response);

                socket.close();
            } else {
                output.writeUTF("Auth failed");
            }
        }
    }

    private static boolean authenticate(Socket socket) throws IOException {
        // Simple authentication here, but in a real-world scenario, you would want
        // to use more secure means of authentication. This is just a placeholder.
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String username = input.readUTF();
        String password = input.readUTF();

        // In a real-world scenario, you would want to hash the password and compare
        // the hashed password with the stored hashed password in the database.
        // This is just a placeholder.
        if (username.equals("admin") && password.equals("password")) {
            output.writeUTF("Auth succeeded");
            return true;
        } else {
            output.writeUTF("Auth failed");
            return false;
        }
    }
}