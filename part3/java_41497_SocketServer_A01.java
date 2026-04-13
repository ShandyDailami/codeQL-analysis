import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_41497_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 12345; // The port on which the server will listen

        try {
            // Initialize server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Initialize reader and writer
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Handle client message
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Implement security sensitive operations here.
                    // For example, checking for broken access control.
                    if (message.contains("broken")) {
                        System.out.println("Broken access control detected. Denying connection.");
                        out.println("Broken access control detected. Denying connection.");
                        clientSocket.close(); // Close the connection
                    } else {
                        System.out.println("Accepted message: " + message);
                        out.println("Server: Accepted message: " + message);
                    }
                }

                // Close the connection
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}