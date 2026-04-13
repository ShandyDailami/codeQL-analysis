import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_08420_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(12345);

        // Accept a new client socket
        Socket socket = serverSocket.accept();

        // Get the client's IP address
        InetAddress clientAddress = socket.getInetAddress();

        // Log the client's IP address
        System.out.println("Client IP: " + clientAddress.getHostAddress());

        // Assume the client is trying to log in with a username and password
        String username = "username";
        String password = "password";

        // Check if the username and password match
        // This is a security-sensitive operation and should be done in a secure manner
        if (authenticateUser(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        // Close the socket
        socket.close();
    }

    // Simulate a secure authentication operation
    private static boolean authenticateUser(String username, String password) {
        // Assume the username and password are correct
        if (username.equals("username") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}