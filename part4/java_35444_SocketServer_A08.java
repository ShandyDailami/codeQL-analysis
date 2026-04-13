import java.io.*;
import java.net.*;
import java.util.*;

public class java_35444_SocketServer_A08 {
    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                clients.add(client);
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
        Thread thread = new Thread(() -> {
            try (InputStream input = client.getInputStream();
                 OutputStream output = client.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                    output.flush();
                }

            } catch (IOException e) {
                clients.remove(client);
                e.printStackTrace();
            }
        });
        thread.start();
    }
}