import java.io.*;
import java.net.*;

public class java_27967_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started. Waiting for client connections...");

        // Infinite loop to accept connections
        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Read password from client
            String password = in.readLine();

            // Check if password is valid (replace this with your own validation logic)
            if ("securePassword".equals(password)) {
                out.println("Connection successful");
            } else {
                out.println("Connection failed");
                socket.close();
                continue;
            }

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
            }

            // Close the socket and handle the connection
            socket.close();
        }
    }
}