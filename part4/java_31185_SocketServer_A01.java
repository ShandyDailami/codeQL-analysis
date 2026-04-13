import java.io.*;
import java.net.*;

public class java_31185_SocketServer_A01 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Create new thread for handling each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        // Handle exceptions appropriately here based on your application's needs.
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_31185_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    // Handle the received message here, if needed.
                    // For now, simply echo back the message.
                    writer.println(clientMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}