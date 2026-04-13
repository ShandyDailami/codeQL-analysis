import java.io.*;
import java.net.*;
import java.util.*;

public class java_15669_SocketServer_A01 {
    private static List<Socket> clients = new ArrayList<>();
    private static DataOutputStream out;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8080); // listening port
            System.out.println("Server started at port 8080");
            while (true) {
                Socket client = server.accept();
                clients.add(client);
                System.out.println("Client connected: " + client.getRemoteSocketAddress());
                out = new DataOutputStream(client.getOutputStream());
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket client) {
        new Thread(() -> {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    // For simplicity, we'll just send back the input string
                    out.writeUTF(input);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(client);
                System.out.println("Client disconnected: " + client.getRemoteSocketAddress());
            }
        }).start();
    }
}