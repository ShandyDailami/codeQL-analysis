import java.io.*;
import java.net.*;
import java.util.*;

public class java_38018_SocketServer_A08 {
    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            clients.add(socket);

            // Thread for handling client communication
            Thread clientHandler = new Thread(new ClientHandler(socket));
            clientHandler.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_38018_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    // TODO: Handle client requests related to integrity failure
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            clients.remove(socket);
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore the exception if it's not our connection
                if (clients.contains(socket)) {
                    System.err.println("Failed to close connection: " + e.getMessage());
                }
            }
        }
    }
}