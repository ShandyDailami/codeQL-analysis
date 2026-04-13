import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03115_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Server is running on port 8189");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Read username and password from client
                // Assuming client sends username and password in a simple format
                // If not, you need to handle the format
                // Assuming client sends a line with the username, then the password
                // If not, you need to handle the format
                // Assuming client sends a line with the password, then the username
                // If not, you need to handle the format
                // Assuming the username and password are separated by a single space
                // If not, you need to handle the format

                // Simulating reading from client
                String clientInput = socket.getInputStream().readLine();
                String[] inputArray = clientInput.split(" ");

                String clientUsername = inputArray[0];
                String clientPassword = inputArray[1];

                // Authenticate with provided username and password
                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    System.out.println("Authentication successful");

                    // If authentication is successful, start communication with client
                    socket.getOutputStream().println("Authentication successful");
                    socket.getOutputStream().flush();
                } else {
                    System.out.println("Authentication failed");

                    // If authentication is failed, close connection with client
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}