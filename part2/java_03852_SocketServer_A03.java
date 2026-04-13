import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03852_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static ServerSocket server = null;

    public static void main(String[] args) {
        startServer(5000);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                executor.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_03852_SocketServer_A03(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    out.writeUTF("Server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}