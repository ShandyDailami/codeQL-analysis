import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class java_01592_SocketServer_A07 {
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Create a new buffered reader for the socket input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read the password from the client
            String clientPassword = reader.readLine();
            System.out.println("Received password: " + clientPassword);

            // Compare the passwords
            if (clientPassword.equals(PASSWORD)) {
                System.out.println("Password accepted.");
                // Send a response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Authentication successful.");
            } else {
                System.out.println("Invalid password.");
                // Send a response back to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Authentication failed.");
           
            }
            socket.close();
        }
    }
}