import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class java_19947_SocketServer_A03 {

    private static final int PORT = 1234;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected.");
                new ClientHandler(socket).start();
            } catch (IOException e) {
                System.out.println("Error while accepting connection.");
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_19947_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error while initializing streams.");
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                if (message.equals("exit")) {
                    handleExit();
                    break;
                } else {
                    handleMessage(message);
                }
            }
        }

        private String readMessage() {
            try {
                return dis.readUTF();
            } catch (IOException e) {
                System.out.println("Error while reading message.");
                e.printStackTrace();
                return null;
            }
        }

        private void handleExit() {
            clients.remove(this);
            broadcastMessage("Client disconnected.");
        }

        private void handleMessage(String message) {
            for (ClientHandler client : clients) {
                client.dos.writeUTF(message);
            }
            broadcastMessage(message);
        }

        private void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                client.dos.writeUTF(message);
           
            }
        }
    }
}