import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class java_04789_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000); // Create server socket on port 8000
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept(); // Wait for client to connect
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) { // Read from client
                System.out.println("Received: " + input);

                // Here, you can add the logic to check the authentication failure of the client
                // For example, you can check the username and password against a database
                // If the authentication fails, send an authentication failure response to the client
                // In this simple example, we'll just print out an error message

                if ("test".equals(input)) {
                    out.println("Authentication failure, username and password required");
                } else {
                    out.println("Received: " + input);
                }
            }

            socket.close(); // Close the connection
        }
    }
}