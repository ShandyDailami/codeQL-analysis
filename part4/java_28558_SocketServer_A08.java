import java.io.*;
import java.net.*;
import java.util.*;

public class java_28558_SocketServer_A08 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server started. Listening on port " + SERVER_PORT + "...");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                clientSockets.add(clientSocket);

                Thread clientHandler = new Thread(new ClientHandler(clientSocket));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_28558_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                clientSockets.remove(clientSocket);
                closeConnection(clientSocket, in, out);
                System.out.println("Client disconnected: " + clientSocket.getRemoteSocketAddress());
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                processMessage(message);
            }
        }

        private void closeConnection(Socket socket, BufferedReader in, PrintWriter out) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
        }

        private String readMessage() {
            try {
                return in.readLine();
            } catch (IOException e) {
                clientSockets.remove(clientSocket);
                closeConnection(clientSocket, in, out);
                System.out.println("Client disconnected: " + clientSocket.getRemoteSocketAddress());
                return null;
            }
        }

        private void processMessage(String message) {
            // Process message (e.g., integrity check, encryption/decryption, etc.)
            // ...
        }
    }
}