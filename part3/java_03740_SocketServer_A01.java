import java.io.*;
import java.net.*;
import java.util.*;

public class java_03740_SocketServer_A01 {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);

            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            // Uncomment the following lines to send a message to the client
            // DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            // out.writeUTF("Hello Client, you are now connected to server!");
        }
    }

    public static void sendMessageToClients(String message) {
        for (Socket socket : clientSockets) {
            try {
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}