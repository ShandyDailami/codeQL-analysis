import java.io.*;
import java.net.*;

public class java_18073_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server is listening on port 6000");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected");

            // create a new thread to handle this client
            new Thread(() -> handleClient(client)).start();
        }
    }

    private static void handleClient(Socket client) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {

            String clientMsg;

            while ((clientMsg = reader.readLine()) != null) {
                System.out.println("Received: " + clientMsg);

                // security-sensitive operation: prevent injection
                // in real application, this should be done at the database level
                clientMsg = clientMsg.replace("<", "&lt;").replace(">", "&gt;");

                writer.println("Server response: " + clientMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}