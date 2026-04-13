import java.io.*;
import java.net.*;
import java.util.*;

public class java_25857_SocketServer_A03 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        server = new ServerSocket(1234); // listen on port 1234
        System.out.println("Server started on port 1234");

        while (true) {
            Socket clientSocket = server.accept();
            clients.add(clientSocket);

            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_25857_SocketServer_A03(Socket socket) {
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
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received message: " + message);

                    // Here you can implement a security-sensitive operation.
                    // For example, you can replace all non-alphanumeric characters with X.
                    message = message.replaceAll("[^a-zA-Z0-9]", "X");

                    out.writeUTF(message);
                    out.flush();
                }

                clients.remove(clientSocket);
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}