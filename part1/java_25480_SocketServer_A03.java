import java.io.*;
import java.net.*;
import java.util.*;

public class java_25480_SocketServer_A03 {
    private static List<Socket> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");
            while (true) {
                Socket client = server.accept();
                clients.add(client);
                new Handler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Error accepting client connection on port 1234");
            System.exit(-1);
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler extends Thread {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_25480_SocketServer_A03(Socket socket) {
            this.client = socket;
            try {
                this.dis = new DataInputStream(client.getInputStream());
                this.dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = dis.readUTF();
                    for (Socket s : clients) {
                        if (s != client) {
                            DataOutputStream out = new DataOutputStream(s.getOutputStream());
                            out.writeUTF("Message received from client: " + message);
                        }
                    }
                }
            } catch (IOException e) {
                clients.remove(client);
                System.out.println("Client disconnected");
            }
        }
    }
}