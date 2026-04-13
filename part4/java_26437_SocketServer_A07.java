import java.io.*;
import java.net.*;
import java.util.*;

public class java_26437_SocketServer_A07 {

    private static int DEFAULT_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {

        // Step 1: Create a ServerSocket on the specified port.
        try {
            server = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server is listening on port: " + server.getLocalPort());
        } catch (IOException e) {
            e.printStackTrace();
            closeServer();
        }

        // Step 2: While server is running, accept connections from clients.
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Step 3: Handle the new connection (handle communication).
                handleConnection(socket);

            } catch (IOException e) {
                e.printStackTrace();
                closeServer();
                break; // Exit from while loop when exception is caught.
            }
        }
    }

    private static void handleConnection(Socket socket) {
        // Step 4: Use a buffered reader and writer to handle the communication.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Step 5: Communication starts here.
            String clientMessage;

            // Step 6: Read the client's message and respond.
            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received client: " + clientMessage);

                // Step 7: Check if the client wants to disconnect.
                if (clientMessage.equals("disconnect")) {
                    System.out.println("Client requested to disconnect.");
                    break; // Break out of the loop if it wants to disconnect.
                }

                // Step 8: Generate a response to the client.
                String response = "Hello, client, your message was: " + clientMessage;

                // Step 9: Send the response back to the client.
                out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeServer() {
        // Step 10: Close the server.
        if (server != null) {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}