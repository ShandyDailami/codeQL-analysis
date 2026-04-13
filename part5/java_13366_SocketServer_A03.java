import java.io.*;
import java.net.*;

public class java_13366_SocketServer_A03 {

    private static final String SERVER_SOCKET = "Server Socket";
    private static final String CLIENT_SOCKET = "Client Socket";
    private static final int PORT = 6789;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            while (true) {

                System.out.println("Waiting for client connection...");

                Socket clientSocket = serverSocket.accept();

                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create input and output streams
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;

                // Send response to client
                out.println("Hello client, you connected to server!");

                // Wait for client input
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received client: " + inputLine);

                    // You can replace this part with code that uses input for injection
                    // For example, if input is a command to execute a command injection, you could execute it:

                    // if (input.equals("command-injection")) {
                    //     Runtime.getRuntime().exec(input);
                    // }

                    // Send response back to client
                    out.println("Server received your message: " + inputLine);
                }

                // Close connection
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}