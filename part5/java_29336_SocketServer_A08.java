import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29336_SocketServer_A08 {
    private static final int SERVER_PORT = 9876;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

        System.out.println("Server started. Listening on port: " + SERVER_PORT);

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handle client connection
            handleClient(in, out, clientSocket);

            // Close connection
            clientSocket.close();
        }
    }

    private static void handleClient(BufferedReader in, PrintWriter out, Socket clientSocket) throws IOException {
        String message;

        // Read message from client
        while ((message = in.readLine()) != null) {
            // Check if the message is not empty
            if (!message.equals("")) {
                // Echo the message back to the client
                out.println("Echo: " + message);
            }
        }
    }
}