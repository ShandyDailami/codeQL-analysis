import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28228_SocketServer_A07 {
    private static final String[] VALID_USERS = {"user1", "user2", "user3"};
    private static final String LOCAL_HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                AuthHandler handler = new AuthHandler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    private static class AuthHandler extends Thread {
        private final Socket socket;

        public java_28228_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here, you would read from the socket to get the username and password.
                // This is a simplistic example and does not include security measures.
                // In a real application, you should read in a format that can be safely unmarshalled into a User object.
                // Also, you should verify the password in the same way as you've done for the username.
                // In this example, we're assuming a simple string comparison.
                String username = socket.getInputStream().readUTF();
                String password = socket.getInputStream().readUTF();

                if (!isValid(username, password)) {
                    // Authentication failed, send an error message back to the client.
                    socket.getOutputStream().writeUTF("FAILURE");
                } else {
                    // Authentication succeeded, send a success message back to the client.
                    socket.getOutputStream().writeUTF("SUCCESS");
                }

            } catch (IOException e) {
                System.out.println("Error in client communication: " + e.getMessage());
            }
        }

        private boolean isValid(String username, String password) {
            // Check if the username and password are in the list of valid users.
            // This is a very simple example and does not include password hashing or secure communication.
            // In a real application, you would use a more secure and encrypted method to compare passwords.
            return java.util.Arrays.asList(VALID_USERS).contains(username)
                    && VALID_USERS[java.util.Arrays.asList(VALID_USERS).indexOf(username)].equals(password);
        }
    }
}