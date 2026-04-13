import java.io.*;
import java.net.*;
import java.util.*;

public class java_38577_SocketServer_A07 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            clients.add(socket);

            // Start new thread for handling client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        Socket socket;

        public java_38577_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Receive message from client
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Simulate authentication failure
                if (message.contains("bad_password")) {
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("A07_AuthFailure");
                    return;
                }

                // Send response back to client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Hello, Client!");

            } catch (Exception e) {
                clients.remove(socket);
                socket.close();
            }
        }
    }
}