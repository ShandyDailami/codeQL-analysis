import java.io.*;
import java.net.*;
import java.util.*;

public class java_25700_SocketServer_A08 {
    private static final int PORT = 9876;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
            clients.add(socket);

            // Start a new thread to handle communication with the client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_25700_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                // Receive message from the client
                String message = in.readLine();
                System.out.println("Received: " + message);

                // Do something with the message (e.g., check for integrity failure)
                if (message.contains("A08_IntegrityFailure")) {
                    out.println("A08_IntegrityFailure detected. Denying connection.");
                    close();
                } else {
                    out.println("Message received. Connection still okay.");
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            clients.remove(socket);
            socket.close();
            in.close();
            out.close();
            System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
        }
    }
}