import java.io.*;
import java.net.*;

public class java_06549_SocketServer_A07 {
    private static int port = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("A client connected");

                // Create a new thread for each client
                Thread thread = new ClientHandler(client);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_06549_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;

            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);

                    // Simulate a security sensitive operation, e.g., check if a user is authenticated
                    if (isAuthenticated(message)) {
                        out.writeUTF("Authenticated user");
                    } else {
                        out.writeUTF("Unauthenticated user");
                    }

                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Simulate the authentication process
        private boolean isAuthenticated(String message) {
            // Implementation depends on your authentication mechanism
            // For simplicity, just check if the message is not null
            return message != null;
        }
    }
}