import java.io.*;
import java.net.*;
import java.util.*;

public class java_16567_SocketServer_A03 {
    private static final int PORT = 8888;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected at: " + clientSocket.getRemoteSocketAddress());

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);

                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_16567_SocketServer_A03(Socket socket) {
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
            String message;
            while (true) {
                try {
                    message = in.readUTF();
                    System.out.println("Received: " + message);

                    // Perform injection check
                    if (message.contains("a03_injection")) {
                        System.out.println("Injection detected, sending response...");
                        out.writeUTF("Injection detected!");
                    } else {
                        System.out.println("Message received: " + message);
                    }

                    out.writeUTF("Thank you for connecting!");

                } catch (IOException e) {
                    e.printStackTrace();
                    clients.remove(this);
                    try {
                        clientSocket.close();
                    } catch (IOException e1) {}
                    break;
                }
            }
        }
    }
}