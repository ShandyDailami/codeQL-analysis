import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class java_34001_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");
        Socket socket = server.accept();
        System.out.println("Client accepted!");

        try (InputStream input = socket.getInputStream(); OutputStream output = socket.getOutputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                if (authenticate(message)) {
                    System.out.println("Authentication successful!");
                    output.write("Authentication successful\n".getBytes());
                } else {
                    System.out.println("Authentication failed!");
                    output.write("Authentication failed\n".getBytes());
                }
            }
        }
        socket.close();
        server.close();
    }

    private static boolean authenticate(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2) {
            return false;
        }
        String username = parts[0];
        String password = parts[1];
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}