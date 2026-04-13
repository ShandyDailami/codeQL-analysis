import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04030_SocketServer_A07 {

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Server started on port 8189");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client connected!");

                // Read username and password from client
                socket.getInputStream().read();
                byte[] usernameBytes = new byte[256];
                socket.getInputStream().read(usernameBytes);
                String username = new String(usernameBytes);

                byte[] passwordBytes = new byte[256];
                socket.getInputStream().read(passwordBytes);
                String password = new String(passwordBytes);

                // Check if the received username and password are correct
                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    System.out.println("Authentication successful!");
                } else {
                    System.out.println("Authentication failed!");
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}