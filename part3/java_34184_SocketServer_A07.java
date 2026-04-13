import java.io.*;
import java.net.*;
import java.util.*;

public class java_34184_SocketServer_A07 {
    private List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(54321);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_34184_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                System.out.println("Received: " + message);
                sendMessage(message);
            }
        }

        private void sendMessage(String message) {
            for (ClientHandler client : clients) {
                try {
                    client.out.writeUTF(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String readMessage() {
            String message;
            try {
                message = in.readUTF();
            } catch (IOException e) {
                clients.remove(this);
                return null;
            }
            return message;
        }
    }
}