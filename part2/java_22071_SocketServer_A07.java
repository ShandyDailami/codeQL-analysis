import java.io.*;
import java.net.*;
import java.util.*;

public class java_22071_SocketServer_A07 {

    private static final int PORT = 8080;
    private static Set<Socket> clients = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at " + PORT);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());
            clients.add(client);
            handleClient(client);
        }
    }

    private static void handleClient(Socket client) {
        Thread thread = new Thread(new ClientHandler(client));
        thread.start();
    }

    private static class ClientHandler implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_22071_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                clients.remove(client);
                closeConnection(client);
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        clients.remove(client);
                        closeConnection(client);
                        break;
                    }
                    // assuming all messages are auth-related
                    if (message.startsWith("auth ")) {
                        String[] parts = message.split(" ");
                        if (!checkAuthentication(parts[1])) {
                            sendMessage("Authentication failed.", out);
                            closeConnection(client);
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                clients.remove(client);
                closeConnection(client);
            }
        }

        private void closeConnection(Socket client) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void sendMessage(String message, DataOutputStream out) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean checkAuthentication(String password) {
            // here you can add code to check the password against a hard-coded or real data source
            // for the purpose of this example
            return password.equals("password");
        }
    }
}