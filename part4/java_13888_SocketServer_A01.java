import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_13888_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting server at port 8080...");
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            new Thread(() -> handleClient(clientSocket)).start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate a security-sensitive operation
                if (message.contains("bad_input")) {
                    System.out.println("Broken access control detected, closing connection.");
                    clientSocket.close();
                    return;
                }

                // Simulate a response to the client
                out.println("Hello, client!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}