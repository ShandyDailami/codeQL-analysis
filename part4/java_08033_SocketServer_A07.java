import java.io.*;
import java.net.*;
import java.util.*;

public class java_08033_SocketServer_A07 {
    private static final String PASSWORD = "securepassword"; // this should be stored securely
    private static ArrayList<String> authenticatedClients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444); // listening on port 4444
            System.out.println("Server started. Waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept(); // waiting for a connection
                System.out.println("Client connected.");

                // Authentication
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String clientPassword = in.readUTF(); // read password from client

                if (clientPassword.equals(PASSWORD)) {
                    System.out.println("Authentication successful.");
                    authenticatedClients.add(clientSocket.getRemoteSocketAddress().toString());
                } else {
                    System.out.println("Authentication failed.");
                    out.writeUTF("Authentication failed. Please try again.");
                    out.flush();
                    clientSocket.close();
                    continue;
                }

                // Data communication
                out.writeUTF("Hello client, you are authenticated.");
                out.flush();

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = "Server received your message: " + message;
                out.writeUTF(response);
                out.flush();

                // Closing connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}