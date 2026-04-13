import java.io.*;
import java.net.*;

public class java_29456_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080; // default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket socket = server.accept();
                handleRequest(socket);
            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            String message = reader.readLine();
            System.out.println("Received: " + message);

            if ("FAILURE".equals(message)) {
                // simulate A08_IntegrityFailure
                writer.println("IntegrityFailure: " + message);
            } else {
                writer.println("Server Response: " + message);
            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }
}