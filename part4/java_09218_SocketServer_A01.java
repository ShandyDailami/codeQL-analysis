import java.io.*;
import java.net.*;

public class java_09218_SocketServer_A01 {

    private static final String SERVER_NAME = "SecureSocketServer";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a ServerSocket and bind it to port 8080
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server " + SERVER_NAME + " started on port " + PORT + ".");

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handle the connection
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed down
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Send a welcome message to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, client, thank you for connecting.");

            // Read a line of text from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = in.readLine();
            System.out.println("Client says: " + line);

            // Send a response back to the client
            out.println("Server says: " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}