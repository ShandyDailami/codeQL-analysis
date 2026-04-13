import java.io.*;
import java.net.*;
import java.util.*;

public class java_05747_SocketServer_A07 {

    private static final int PORT = 9876;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                clients.add(writer);

                handleClient(socket, writer);
            } catch (IOException e) {
                System.out.println("Failed to accept connection from " + e.getMessage());
            }
        }
    }

    private static void handleClient(Socket socket, PrintWriter writer) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            while (true) {
                String message = in.readUTF();
                System.out.println("Received: " + message);

                if (message.equals("quit")) {
                    clients.remove(writer);
                    writer.close();
                    System.out.println("Client disconnected");
                    break;
                }

                for (PrintWriter client : clients) {
                    if (client != writer) {
                        client.println(message);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client " + e.getMessage());
        }
    }
}