import java.io.*;
import java.net.*;
import java.util.*;

public class java_19047_SocketServer_A07 {
    private static final int PORT = 1234;
    private static Set<PrintWriter> clients = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected.");

            // Send the client a welcome message
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Welcome to the server!");

            clients.add(out);

            // Handle client's message
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_19047_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    // Broadcast message to all clients
                    for (PrintWriter client : clients) {
                        client.println(message);
                    }
                }
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            clients.remove(out);
            out.close();
            socket.close();
        }
    }
}