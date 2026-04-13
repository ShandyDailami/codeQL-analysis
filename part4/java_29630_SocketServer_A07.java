import java.io.*;
import java.net.*;
import java.util.*;

public class java_29630_SocketServer_A07 {
    private static final int PORT = 8080;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected");
                handleClient(socket);
            } catch (IOException e) {
                System.out.println("Error accepting client connection");
                e.printStackTrace();
                server.close();
            }
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        clients.add(out);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message;

        while ((message = in.readLine()) != null) {
            if (message.equals("exit")) {
                clients.remove(out);
                out.close();
                break;
            }

            // Security sensitive operation: Authentication and authorization
            if (message.contains("auth")) {
                String[] parts = message.split(":");
                String username = parts[1];
                if (isValidUser(username)) {
                    out.println("auth:valid");
                } else {
                    out.println("auth:invalid");
                }
            } else {
                // Security sensitive operation: Encryption
                message = encryptMessage(message);
                for (PrintWriter client : clients) {
                    client.println(message);
                }
            }
        }
    }

    // Implement your authentication logic here
    private static boolean isValidUser(String username) {
        // You can use an actual authentication mechanism, e.g. a database
        // This is a simplistic example, you should not use this in a production environment
        return true;
    }

    // Implement your encryption logic here
    private static String encryptMessage(String message) {
        // You can use a simple encryption algorithm, e.g. XOR with a key
        // This is a simplistic example, you should not use this in a production environment
        byte[] bytes = message.getBytes();
        byte key = 123;
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= key;
        }
        return new String(bytes);
    }
}