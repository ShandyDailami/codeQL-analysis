import java.io.*;
import java.net.*;
import java.util.*;

public class java_34122_SocketServer_A08 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clients.add(clientSocket);

            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            Thread clientHandler = new Thread(() -> handleClient(clientSocket));
            clientHandler.start();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            out.writeUTF("Message received: " + message);

            for (Socket client : clients) {
                out.writeUTF("Message to all clients: " + message);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}