import java.io.*;
import java.net.*;
import java.util.*;

public class java_16119_SocketServer_A01 {
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static int clientIdCounter = 0;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started.");

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client accepted.");

                ClientHandler client = new ClientHandler(clientSocket, clientIdCounter++);
                clients.add(client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;
        private int clientId;

        public java_16119_SocketServer_A01(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Client " + clientId + ": " + message);

                    // Check for broken access control
                    if (message.toLowerCase().contains("badword")) {
                        writer.writeBytes("Broken access control violation!\n");
                        writer.flush();

                        // Implement security-sensitive operations
                        // (e.g., ban client for further attempts)

                        System.out.println("Banned client " + clientId + " for violating access control.");
                        clients.remove(this);
                        socket.close();
                        return;
                    }

                    writer.writeBytes(message + "\n");
                    writer.flush();
                }

                socket.close();
                clients.remove(this);
            } catch (IOException e) {
                System.out.println("Client error: " + e.getMessage());
                e.printStackTrace();
           
                clients.remove(this);
            }
        }
    }
}