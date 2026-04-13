import java.io.*;
import java.net.*;
import java.util.*;

public class java_07845_SocketServer_A07 {
    private static final int PORT = 9876;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket client = server.accept();
                clients.add(client);
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket client) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("exit")) {
                    clients.remove(client);
                    out.println("Client has disconnected");
                    break;
                } else {
                    out.println("Server received: " + message);
                    for (Socket sock : clients) {
                        try (OutputStream outToClient = sock.getOutputStream()) {
                            String response = "Server received: " + message;
                            outToClient.write(response.getBytes());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            clients.remove(client);
        }
    }
}