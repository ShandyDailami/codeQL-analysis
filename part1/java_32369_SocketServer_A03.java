import java.io.*;
import java.net.*;
import java.util.*;

public class java_32369_SocketServer_A03 {
    private static final int PORT = 4446;

    private Set<Socket> clientSockets;
    private ServerSocket serverSocket;

    public java_32369_SocketServer_A03() {
        clientSockets = Collections.newSetFromIterator(Arrays.asList(new Socket[] {}));
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);
            acceptClients();
        } catch (IOException e) {
            System.err.println("Could not start server on port " + PORT);
        }
    }

    private void acceptClients() {
        while (true) {
            try {
                Socket newClient = serverSocket.accept();
                System.out.println("Client connected from " + newClient.getRemoteSocketAddress());
                clientSockets.add(newClient);
                handleClient(newClient);
            } catch (IOException e) {
                System.err.println("Could not accept new client connection");
                clientSockets.removeIf(socket -> socket.getRemoteSocketAddress().equals(serverSocket.getInetAddress())
                        || socket.getPort() == PORT);
            }
        }
    }

    private void handleClient(Socket client) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                // Process the received data as per requirement
                // Here, we're just echoing back the received data
                String response = "Server response: " + line;
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                out.println(response);
            }
        } catch (IOException e) {
            System.err.println("Error handling client connection");
            clientSockets.remove(client);
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer();
    }
}