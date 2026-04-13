import java.io.*;
import java.net.*;
import java.util.*;

public class java_29254_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket client = server.accept();
                clients.add(client);

                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                Thread clientThread = new Thread(new ClientHandler(client));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_29254_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Received: " + message);

                    if (message.equals("exit")) {
                        clients.remove(clientSocket);
                        clientSocket.close();
                        break;
                    }

                    // Here is where we introduce the A08_IntegrityFailure
                    // We are introducing a server-side check to ensure no malicious client is sending us invalid data
                    String response = "Server received: " + message;
                    for (Socket client : clients) {
                        output.writeUTF(response);
                        output.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}