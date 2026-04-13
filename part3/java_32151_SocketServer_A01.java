import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32151_SocketServer_A01 {
    private static final int PORT = 6789;

    public static void main(String[] args) {
        // Start the server
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                // Accept a new client
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Handle communication with the client
                handleClient(socket);
            }
        } catch (IOException ex) {
            System.err.println("Failed to start server: " + ex.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        // Create a buffered reader to read data from the client
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            // Create a writer to write data to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);

                // Here is a simple attempt to break the connection with a broken access control
                if (input.equals("BREAK")) {
                    out.println("Connection broken due to A01_BrokenAccessControl");
                    break;
                }

                out.println("Echo: " + input);
            }
        } catch (IOException ex) {
            System.err.println("Failed to handle client: " + ex.getMessage());
        }
    }
}