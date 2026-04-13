import java.io.*;
import java.net.*;
import java.util.*;

public class java_27812_SocketServer_A08 {

    private static ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(6000);
            System.out.println("Server started at port 6000");
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected at " + client.getRemoteSocketAddress());
                clients.add(client);
                HandleClientThread thread = new HandleClientThread(client);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class HandleClientThread extends Thread {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_27812_SocketServer_A08(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    for (Socket sock : clients) {
                        out = new DataOutputStream(sock.getOutputStream());
                        out.writeUTF(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}