import java.io.*;
import java.net.*;
import java.util.*;

public class java_13646_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port + "...");
            while (true) {
                handleClient(server.accept());
            }
        } catch (IOException e) {
            System.out.println("Server failed to start.");
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
        try {
            OutputStream out = new BufferedOutputStream(client.getOutputStream());
            InputStream in = new BufferedInputStream(client.getInputStream());

            // Receive request
            byte[] buffer = new byte[1024];
            int bytesCount = in.read(buffer);
            String request = new String(buffer, 0, bytesCount);
            System.out.println("Received: " + request);

            // Send response
            String response = "Hello, client!";
            out.write(response.getBytes());
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}