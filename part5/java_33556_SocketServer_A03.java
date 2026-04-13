import java.io.*;
import java.net.*;
import java.util.*;

public class java_33556_SocketServer_A03 {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started at port: " + server.getLocalPort());

        while (true) {
            Socket socket = server.accept();
            clients.add(socket);

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream input;
        private DataOutputStream output;

        public java_33556_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = readMessage()) != null) {
                sendMessageToAll("SERVER: " + message);
            }
        }

        private String readMessage() {
            try {
                return input.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
           
                clients.remove(socket);
                closeConnection();
            }
            return null;
        }

        private void sendMessageToAll(String message) {
            for (Socket client : clients) {
                try {
                    output.writeUTF(message);
                } catch (IOException e) {
                    e.printStackTrace();
                    clients.remove(client);
                    closeConnection();
                }
            }
        }

        private void closeConnection() {
            try {
                input.close();
                output.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}