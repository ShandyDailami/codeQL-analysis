import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03958_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String message = reader.readLine();
                System.out.println("Received message: " + message);

                // Process the message (for example, print it to the console)
                System.out.println("Processing message...");

                // Send a response back to the client
                String response = "Server received your message: " + message;
                writer.write("Server response: " + response);
                writer.newLine();
                writer.flush();

                System.out.println("Sent response back to the client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}