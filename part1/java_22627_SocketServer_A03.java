import java.io.*;
import java.net.*;
import java.util.*;

public class java_22627_SocketServer_A03 {
    private static final String DISCONNECT_MESSAGE = "DISCONNECT";
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                // Assign unique ID to each client
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientID = reader.readLine();
                writer.println("CLIENT_ID_RECEIVED");
                writer.println(clientID);

                clientSockets.add(clientSocket);
                handleClient(clientSocket, clientID);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket, String clientID) {
        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received from client: " + message);

                    // Broadcast the message to all clients
                    for (Socket socket : clientSockets) {
                        if (socket != clientSocket) {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(clientID + ": " + message);
                        }
                    }

                    if (message.equals(DISCONNECT_MESSAGE)) {
                        clientSockets.remove(clientSocket);
                        System.out.println("Client disconnected");
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}