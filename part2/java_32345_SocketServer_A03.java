import java.io.*;
import java.net.*;
import java.util.*;

public class java_32345_SocketServer_A03 {

    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final int MAX_CONNECTIONS = 10;

    private static List<ClientHandler> connectedClients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT, MAX_CONNECTIONS);
            System.out.println("Server is running on port " + SERVER_PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getRemoteSocketAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                connectedClients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_32345_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    handleRequest(request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            closeConnection();
        }

        private void handleRequest(String request) {
            // Handle the request here using the request
            // Add your security measures here if necessary
        }

        private void closeConnection() {
            connectedClients.remove(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connection closed with " + socket.getRemoteSocketAddress());
        }
    }
}