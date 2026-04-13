import java.io.*;
import java.net.*;
import java.util.*;

public class java_40167_SocketServer_A01 {

    private static final int PORT = 8080;
    private static final String INPUT_LINE = ">> ";
    private static final String ERROR_INPUT = "Invalid input!";
    private static final String SERVER_STARTED = "Server started on port ";
    private static Set<Socket> connectedClients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println(SERVER_STARTED + server.getLocalPort());
            while (true) {
                try (Socket client = server.accept()) {
                    connectedClients.add(client);
                    System.out.println("Client connected: " + client.getRemoteSocketAddress());
                    handleClient(client);
                }
            }
        }
    }

    private static void handleClient(Socket client) {
        try (InputStreamReader input = new InputStreamReader(client.getInputStream());
             BufferedReader reader = new BufferedReader(input)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if ("exit".equals(line)) {
                    connectedClients.remove(client);
                    System.out.println("Client disconnected: " + client.getRemoteSocketAddress());
                    break;
                } else {
                    System.out.println(INPUT_LINE + line);
                    sendToAll(line);
                }
            }
        } catch (IOException e) {
            connectedClients.remove(client);
            System.out.println("Client disconnected: " + client.getRemoteSocketAddress());
            System.out.println(ERROR_INPUT);
        }
    }

    private static void sendToAll(String message) {
        for (Socket client : connectedClients) {
            try (OutputStream out = client.getOutputStream()) {
                out.write(message.getBytes());
                out.flush();
            } catch (IOException e) {
                System.out.println(ERROR_INPUT);
            }
        }
    }
}