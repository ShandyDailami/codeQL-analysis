import java.net.*;
import java.io.*;

public class java_39963_SocketServer_A03 {
    private static int port = 4445;

    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);

            // Listen for client connections
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getInetAddress() + " connected");

                // Handle client connection in a new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles multiple client requests in a separate thread
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_39963_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                closeResources();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                // Listen for a message from the client
                while ((message = in.readUTF()) != null) {
                    // Check if the message contains a command to execute an injection attack
                    if (message.contains("command=")) {
                        // Remove the command and execute an injection attack
                        message = message.replace("command=", "");
                        new InjectionAttack(message).execute();
                    } else {
                        // Handle the message normally
                        out.writeUTF("Received: " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeResources();
            }
        }

        private void closeResources() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Class to simulate an injection attack
    private static class InjectionAttack {
        private final String command;

        public java_39963_SocketServer_A03(String command) {
            this.command = command;
        }

        public void execute() {
            // Simulate an injection attempt by executing the command
            System.out.println("Injection attack: " + command);
            // ... actual code here ...
        }
    }
}