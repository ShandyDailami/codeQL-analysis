import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00549_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started. Waiting for client connection...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Here we assume the client sends a username.
            // In a real-world scenario, this would be done using a protocol like a handshake.
            String username = socket.getInputStream().readUTF();

            // Here, we're just checking if the username is valid. In a real-world scenario, this would be done in a secure way.
            if (isValidUsername(username)) {
                System.out.println("Username is valid!");
                // If username is valid, we proceed with authentication.
                // In a real-world scenario, this would be done using secure handshake.
                authenticateUser(username);
            } else {
                System.out.println("Username is invalid!");
                // If username is invalid, we send an auth failure message.
                sendAuthFailureMessage(socket);
            }

            socket.close();
        }
    }

    private static boolean isValidUsername(String username) {
        // Here you would implement a secure check to see if the username is valid.
        // For simplicity, we'll just return true here.
        return true;
    }

    private static void authenticateUser(String username) {
        // Here you would implement the authentication logic for the user.
        // For simplicity, we'll just print out the username here.
        System.out.println("Authenticating user: " + username);
    }

    private static void sendAuthFailureMessage(Socket socket) {
        try {
            // Here you would implement the protocol to send an auth failure message.
            // For simplicity, we'll just send a message as bytes.
            socket.getOutputStream().write("Auth Failure".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}