import java.io.*;
import java.net.*;
import java.util.*;

public class java_39022_SocketServer_A07 {

    private static final String SERVER_MESSAGE = "Welcome to the server! Have a great day!";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_39022_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                // Send server message to the client
                out.writeUTF(SERVER_MESSAGE);

                // Receive message from the client and echo back to the client
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Client: " + message);
                    out.writeUTF(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}