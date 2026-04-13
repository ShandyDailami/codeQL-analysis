import java.io.*;
import java.net.*;
import java.util.*;

public class java_33675_SocketServer_A03 {

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(5000);
            System.out.println("Server started at port 5000");

            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = server.accept();
                System.out.println("Client accepted!");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ClientHandler extends Thread {

        private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_33675_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = input.readUTF();
                    System.out.println("Received: " + message);

                    for (ClientHandler client : clients) {
                        if (client != this) {
                            client.sendMessage(message);
                        }
                    }
                }

            } catch (IOException e) {
                clients.remove(this);
                try {
                    socket.close();
                    input.close();
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Client disconnected!");
            }
        }

        public void sendMessage(String message) {
            try {
                output.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}