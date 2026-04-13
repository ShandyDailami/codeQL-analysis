import java.io.*;
import java.net.*;
import java.util.*;

public class java_20525_SocketServer_A07 {

    private static final String SERVER_NAME = "SecureSocketServer";
    private static final int SERVER_PORT = 8080;

    private static Set<Socket> connectedClients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is running on port: " + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            connectedClients.add(clientSocket);

            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_20525_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message from client: " + message);

                    // Here, we can implement the authentication mechanism
                    // For the sake of simplicity, we'll just echo the message back
                    out.println(message);
                }
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            connectedClients.remove(clientSocket);
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getRemoteSocketAddress());
        }
    }
}