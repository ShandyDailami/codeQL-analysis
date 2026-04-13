import java.io.*;
import java.net.*;
import javax.security.auth.message.callback.PasswordCallback;

public class java_31375_SocketServer_A08 {

    public static void main(String[] args) {

        // Create a socket server on port 1234
        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            System.out.println("Server is listening on port 1234");

            // Wait for client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // Receive password
            String password = in.readUTF();
            System.out.println("Received password: " + password);

            // Check if password is correct
            if (password.equals("correct_password")) {
                // Send response to client
                out.writeUTF("Access granted");
            } else {
                out.writeUTF("Access denied");
            }

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}