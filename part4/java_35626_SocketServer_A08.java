import java.io.*;
import java.net.*;
import java.util.*;

public class java_35626_SocketServer_A08 {
    private static ArrayList<Socket> clients = new ArrayList<>();
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            while (true) {
                Socket client = serverSocket.accept();
                clients.add(client);

                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                Thread clientHandler = new Thread(new ClientHandler(client));
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;

        public java_35626_SocketServer_A08(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream input = client.getInputStream();
                DataInputStream dis = new DataInputStream(input);

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                OutputStream output = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF("Server received your message!");

                client.close();
                clients.remove(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}